package com.tts.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of veterinarians. Mostly here to be used for the 'products' {@link
 * org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Eric
 */
@XmlRootElement(name = "products")
public class Products {
    private List<Product> products;

    @XmlElement
    public List<Product> getVetList() {
        if (products == null) {
        	products = new ArrayList<Product>();
        }
        return products;
    }
}