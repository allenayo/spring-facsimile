package com.cjp.beans;

public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
