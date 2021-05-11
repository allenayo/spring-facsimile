package com.cjp.context;

import com.cjp.UserService;
import org.junit.Test;

public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }
}
