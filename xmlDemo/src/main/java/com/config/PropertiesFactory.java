/**
 * Created by qunxing.du on 2017/6/20.
 * Copyright 2017-2018 汉威.智慧环保事业部 Limited.
 * All rights reserved.
 */
package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 系统配置资源工厂
 * <pre>
 *     加载系统配置的所有属性资源，并对外提供
 * </pre>>
 */
public class PropertiesFactory {

    private static Logger log = LoggerFactory.getLogger(PropertiesFactory.class);

    private static Properties properties = new Properties();

    private PropertiesFactory(){}

    private static PropertiesFactory propertiesFactory;

    public static PropertiesFactory getInstance(){
        if(null == propertiesFactory){
            propertiesFactory = new PropertiesFactory();
        }
        return propertiesFactory;
    }

    public void init() {
        log.debug("加载资源");
        loadResources();
    }
    public void destory() {
        log.debug("销毁资源");
        properties = null;
    }
    private void loadResources(){
        String defaultLocations = "classpath*:default/conf/*";
        String extLocations = "classpath*:ext/conf/*";
        log.debug("加载默认资源");
        loadSpecifiedResources(defaultLocations);
        log.debug("加载自定义资源");
        loadSpecifiedResources(extLocations);
    }

    private void loadSpecifiedResources(String locations){
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources(locations);
            for(Resource resource : resources){
                log.debug(String.format("加载位于{%s}资源文件：{%s}",locations, resource.getFilename()));
                Properties props = PropertiesLoaderUtils.loadProperties(resource);
                properties.putAll(props);
            }
        } catch (IOException e) {
            log.error("系统资源加载失败",e);
        }
    }

    /**
     * 通过key获取value
     * @return
     */
    public static String get(String key){
        String value = properties.getProperty(key);
        log.debug(String.format("资源：%s:%s",key,value));
        return value;
    }

    public static Integer getInteger(String key){
        String value = properties.getProperty(key);
         log.debug(String.format("资源：%s:%s",key,value));
        if(null != value && !value.isEmpty()){
            return Integer.parseInt(value);
        }
        return null;
    }
}
