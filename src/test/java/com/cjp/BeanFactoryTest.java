package com.cjp;

import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test() {
        // 1. 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 初始化Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        // 3. 注册Bean
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4. 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayHello();
    }
}
