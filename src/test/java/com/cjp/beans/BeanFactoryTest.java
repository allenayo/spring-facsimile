package com.cjp.beans;

import com.cjp.UserService;
import com.cjp.beans.factory.AbstractBeanFactory;
import com.cjp.beans.factory.AutowireCapableBeanFactory;
import com.cjp.beans.factory.BeanFactory;
import com.cjp.beans.io.ResourceLoader;
import com.cjp.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void testLazy() throws Exception {
        // 1. 读取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("test.xml");

        // 2. 初始化BeanFactory
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 3. 注册Bean
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        // 4. 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayHello();
    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 1. 读取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("test.xml");

        // 2. 初始化BeanFactory
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 3. 注册Bean
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        // 4. 初始化bean
        beanFactory.preInstantiateSingletons();

        // 5. 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayHello();
    }
}
