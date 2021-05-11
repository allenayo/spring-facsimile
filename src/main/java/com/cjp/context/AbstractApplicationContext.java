package com.cjp.context;

import com.cjp.beans.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public abstract void refresh() throws Exception;

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
