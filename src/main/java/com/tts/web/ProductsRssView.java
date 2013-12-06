package com.tts.web;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;
import com.tts.entity.Product;
import com.tts.entity.Products;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;
/**
 * A view creating a Atom representation from a list of Visit objects.
 *
 * User: eric
 * Date: 13-6-14
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class ProductsRssView extends AbstractRssFeedView {
    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
        feed.setDescription("tag:mytt.cloudfoundry.com");
        feed.setTitle("products");
        feed.setLink("http://mytt.cloudfoundry.com");

        super.buildFeedMetadata(model, feed, request);
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Products products = (Products) model.get("products");
        List<Product> productList = products.getVetList();

        Item item = null;Content content = null;
        List<Item> items = new ArrayList<Item>(productList.size());
        for (Product p : productList) {
            item = new Item();
            item.setComments(String.format("tag:mytt.cloudfoundry.com,%s", p.getId()));
            item.setTitle(String.format("Product: %s %s", p.getTitle(), p.getTime()));
            item.setAuthor("Eric");
            item.setLink("http://mytt.cloudfoundry.com/"+p.getId());

            content = new Content();
            content.setValue(p.getTitle());
            item.setContent(content);

            items.add(item);
        }
        response.setContentType("blabla");
        return items;
    }
}