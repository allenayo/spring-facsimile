package com.cjp;

import com.cjp.factory.AutowireCapableBeanFactory;
import com.cjp.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1. 初始化BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2. 初始化Bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.cjp.UserService");

        // 3. 注入属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "Ronaldo"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4. 注册Bean
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayHello();
    }
}
