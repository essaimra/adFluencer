package com.adfluence;


import com.adfluence.util.SpringInjector;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ServiceSetupApplicationListener implements ApplicationListener<ApplicationReadyEvent>, Ordered{

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        setupSpringInjector(event.getApplicationContext());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }


    private void setupSpringInjector(ConfigurableApplicationContext applicationContext) {
        SpringInjector springInjector = applicationContext.getBean(SpringInjector.class);
        springInjector.setApplicationContext(applicationContext);
    }
}
