package com.tts.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

/**
 * SpringMVC使用@ResponseBody输出字符串时遇到的乱码解决办法
 * User: eric
 * Date: 13-5-6
 * Time: 下午12:12
 * To change this template use File | Settings | File Templates.
 */
public class StringHttpMessageConverter  extends AbstractHttpMessageConverter<String> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private final Charset defaultCharset;

    private final List<Charset> availableCharsets;

    private boolean writeAcceptCharset = true;


    /**
     * A default constructor that uses {@code "ISO-8859-1"} as the default charset.
     * @see #StringHttpMessageConverter(Charset)
     */
    public StringHttpMessageConverter() {
        this(DEFAULT_CHARSET);
    }

    /**
     * A constructor accepting a default charset to use if the requested content
     * type does not specify one.
     */
    public StringHttpMessageConverter(Charset defaultCharset) {
        super(new MediaType("text", "plain", defaultCharset), MediaType.ALL);
        this.defaultCharset = defaultCharset;
        this.availableCharsets = new ArrayList<Charset>(Charset.availableCharsets().values());
    }

    /**
     * Indicates whether the {@code Accept-Charset} should be written to any outgoing request.
     * <p>Default is {@code true}.
     */
    public void setWriteAcceptCharset(boolean writeAcceptCharset) {
        this.writeAcceptCharset = writeAcceptCharset;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.equals(clazz);
    }

    @Override
    protected String readInternal(@SuppressWarnings("rawtypes") Class clazz, HttpInputMessage inputMessage) throws IOException {
        Charset charset = getContentTypeCharset(inputMessage.getHeaders().getContentType());
        return FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));
    }

    @Override
    protected Long getContentLength(String s, MediaType contentType) {
        Charset charset = getContentTypeCharset(contentType);
        try {
            return (long) s.getBytes(charset.name()).length;
        }
        catch (UnsupportedEncodingException ex) {
            // should not occur
            throw new IllegalStateException(ex);
        }
    }

    @Override
    protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException {
        if (this.writeAcceptCharset) {
            outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
        }
        Charset charset = getContentTypeCharset(outputMessage.getHeaders().getContentType());
        FileCopyUtils.copy(s, new OutputStreamWriter(outputMessage.getBody(), charset));
    }

    /**
     * Return the list of supported {@link Charset}.
     * <p>By default, returns {@link Charset#availableCharsets()}. Can be overridden in subclasses.
     * @return the list of accepted charsets
     */
    protected List<Charset> getAcceptedCharsets() {
        return this.availableCharsets;
    }

    private Charset getContentTypeCharset(MediaType contentType) {
        if (contentType != null && contentType.getCharSet() != null) {
            return contentType.getCharSet();
        }
        else {
            return this.defaultCharset;
        }
    }
}