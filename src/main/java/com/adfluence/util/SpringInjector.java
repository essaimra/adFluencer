package com.adfluence.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SpringInjector{

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringInjector.class);
    protected static ApplicationContext applicationContext;


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringInjector.applicationContext != null) {
            LOGGER.error("Spring Injector already configured. old context: {}, new context: {}", SpringInjector.applicationContext, applicationContext);
//			throw PException.create("Spring injector already configured with application context");
        }
        SpringInjector.applicationContext = applicationContext;
    }


    public static <T> T getInstanceByType(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }


}
