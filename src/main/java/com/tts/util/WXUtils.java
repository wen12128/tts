package com.tts.util;

import com.google.common.collect.Lists;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 验证.
 * User: eric
 * Date: 13-12-3
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
public class WXUtils {
    private final static String TOKEN = "wxt";

    public static boolean check(String signature, String timestamp,String nonce) {
        if (signature == null || timestamp == null || nonce == null) {
            return false;
        }

        List<String> list = Lists.newArrayList(TOKEN, timestamp, nonce);
        Collections.sort(list);
        /*String[] list = {TOKEN,timestamp,nonce};Arrays.sort(list);*/

        StringBuffer message = new StringBuffer();
        for (String m : list) {message.append(m);}

        String digest = Cryptos.SHA1(message.toString());

        if (signature.toLowerCase().equals(digest)) {
            return true;
        } else  {
            return false;
        }
    }

    public static  <T> String toJson(T bean) {
        JsonMapper binder = JsonMapper.nonEmptyMapper();
        return binder.toJson(bean);
    }
    public static  <T> T fromObject(String json, Class<T> className) {
        JsonMapper binder = JsonMapper.nonEmptyMapper();
        return binder.fromJson(json,className);
    }

    public static  <T> String toXmlByObject(String encode, T obj) {
        StringWriter sw = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass(), CollectionWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            if (StringUtils.isNotBlank(encode)) {
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encode);
            }
            //去掉xml默认报文头
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            //不转义特殊字符<!CDATA[]]
            jaxbMarshaller.setProperty("com.sun.xml.bind.marshaller.CharacterEscapeHandler", new CharacterEscapeHandler() {
                @Override
                public void escape(char[] ch, int start,int length, boolean isAttVal, Writer writer) throws IOException {
                    writer.write(ch, start, length);
                }
            });
            sw = new StringWriter();
            //添加自己想要的xml报文头sw.write("<?xml version=\'1.0\' encoding=\'" + encode + "\'?>\n");

            jaxbMarshaller.marshal(obj, sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (sw!=null) {
                try {
                    sw.flush();
                    sw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String toXmlByList(Collection<?> root, String rootName, Class clazz, String encoding) {
        StringWriter writer = null;
        try {
            CollectionWrapper wrapper = new CollectionWrapper();
            wrapper.collection = root;

            JAXBElement<CollectionWrapper> wrapperElement = new JAXBElement<CollectionWrapper>(new QName(rootName), CollectionWrapper.class, wrapper);

            writer = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz, CollectionWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            if (StringUtils.isNotBlank(encoding)) {
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            }
            jaxbMarshaller.marshal(wrapperElement, writer);

            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            if (writer!=null){
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    @SuppressWarnings(value={ "unchecked "})
    public static  <T> String toXmlByObject2(String encode, T obj, List<T> list, String wrapperName) {
        StringWriter sw = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Wrapper.class, obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            if (StringUtils.isNotBlank(encode)) {
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, encode);
            }

            QName qName = new QName(wrapperName);
            Wrapper wrapper = new Wrapper(list);
            JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName, Wrapper.class, wrapper);

            sw = new StringWriter();
            jaxbMarshaller.marshal(jaxbElement, sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (sw!=null) {
                try {
                    sw.flush();
                    sw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings(value={ "unchecked "})
    public static  <T> T toObjectByXml(String message, Class<T> className) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(className);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            //unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

            T object = (T) unmarshaller.unmarshal(new StringReader(message));
            return object;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    @SuppressWarnings(value={ "unchecked "})
    public static  <T> List<T> toObjectByXml2(String message, Class<T> className) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Wrapper.class, className);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Wrapper<T> wrapper = (Wrapper<T>)unmarshaller.unmarshal(new StreamSource(new StringReader(message)), Wrapper.class).getValue();

            return wrapper.getItems();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class CollectionWrapper {
        @XmlAnyElement
        protected Collection<?> collection;
    }
    private static class Wrapper<T> {
        private List<T> items;

        public Wrapper() {
            items = new ArrayList<T>();
        }

        public Wrapper(List<T> items) {
            this.items = items;
        }

        @XmlAnyElement(lax=true)
        public List<T> getItems() {
            return items;
        }
    }
}