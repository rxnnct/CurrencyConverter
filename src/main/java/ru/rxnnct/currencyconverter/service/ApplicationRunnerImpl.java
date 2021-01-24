package ru.rxnnct.currencyconverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    private final ApplicationContext applicationContext;

    @Autowired
    public ApplicationRunnerImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!applicationContext.getBean(CbrXmlHandler.class).checkDataRelevance()) {
            applicationContext.getBean(CbrXmlHandler.class).saveXmlToDatabase();
        }
    }
}
