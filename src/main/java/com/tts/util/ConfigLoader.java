package com.tts.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class ConfigLoader implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

    private static volatile Map configuration = null;

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private ConfigLoader() {
        try {
            new Thread(new ReloadConfigThread()).start();
        } catch (Exception e) {
            logger.error("<ConfigLoader> start reload thread fail!", e);
        }
    }

    /**
     * 初始化参数配置.
     * <p>
     * 初始化时会从 SystemParameter.properties 中取得 APP 和 SITE 参数，如果取不到这两个参数，可能会初始化失败.
     * </p>
     * <p>
     * 可以多次 reload .
     * </p>
     */
    public static synchronized void initialize() {
        if (logger.isDebugEnabled()) {
            logger.debug("-----------------------------------------------------");
            logger.debug(" 初始化参数");
            logger.debug("-----------------------------------------------------");
        }
        configuration = loadSystemParameter();
        if (logger.isDebugEnabled()) {
            logger.debug("参数初始化完成!");
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap loadSystemParameter() {
        Properties param = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("SystemParameter.properties");
        if (stream == null) {
            return new HashMap();
        }
        try {
            param.load(stream);
            stream.close();
        } catch (IOException e) {
            param = null;
            e.printStackTrace();
        }

        if (param == null) {
            return new HashMap();
        }
        HashMap result = new HashMap();
        result.putAll(param);
        return result;
    }

    /**
     * 重新装装参数信息.
     */
    @SuppressWarnings("unchecked")
    public synchronized static void reload() {
        if (logger.isDebugEnabled()) {
            logger.debug("-----------------------------------------------------");
            logger.debug(" 重新装载参数信息");
            logger.debug("-----------------------------------------------------");
        }
        Map<String, String> map = loadSystemParameter();
        if(map.size() < 1){
            logger.error("<reload> reload fail!");
            return;
        }

        configuration = map;
        if (logger.isDebugEnabled()) {
            logger.debug("重新加载完成!");
        }
    }

    /**
     * auto reload config thread
     */
    class ReloadConfigThread implements Runnable {
        private Logger logger = LoggerFactory.getLogger(ReloadConfigThread.class);

        public void run() {
            while (true) {
                if (logger.isDebugEnabled()) {
                    logger.debug("<run> begin reload config info!");
                }
                try {
                    this.waitTime(2);
                } catch (Exception e) {
                    logger.error("<run> reload config fail!", e);
                }
            }
        }

        public synchronized void waitTime(int minute) {
            try {
                wait(minute * 60 * 1000);
            } catch (Exception e) {
                logger.error("<waitTime> wait exec fail!", e);
            }
        }
    }

    //---------------------------------------------------------------------------------


    @SuppressWarnings("unchecked")
    public static void set(String key, String value) {
        if (configuration == null) {
            configuration = new HashMap();
        }
        configuration.put(key, value);
    }

    public static String get(String key) {
        if (configuration == null) {
            logger.warn("现在试着重装加载一下本地SystemParameter.properties......");
            reload();
        }
        if (key == null) {
            key = "";
        }
        return (String) configuration.get(key);
    }

    @SuppressWarnings("unchecked")
    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    @SuppressWarnings("unchecked")
    public static boolean getAsBoolean(String key) {
        return Boolean.valueOf(get(key));
    }

    /**
     * MemCache是否开启
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean getMCacheOpen() {
        if (get("MEM_CACHED_OPEN") != null && get("MEM_CACHED_OPEN").equals("1")) {
            return true;
        }
        return false;
    }
}
