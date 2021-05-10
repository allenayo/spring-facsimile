package com.cjp.factory;

import com.cjp.BeanDefinition;
import com.cjp.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyVlaues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyVlaues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue p : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(p.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, p.getValue());
        }
    }
}
