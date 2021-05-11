package com.cjp;

import com.cjp.factory.AbstractBeanFactory;
import com.cjp.factory.AutowireCapableBeanFactory;
import com.cjp.factory.BeanFactory;
import com.cjp.io.ResourceLoader;
import com.cjp.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void testLazy() throws Exception {
        // 1. 读取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("test.xml");

        // 2. 初始化BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

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
