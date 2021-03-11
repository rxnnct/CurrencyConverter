package ru.rxnnct.currencyconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CurrencyConverterApplication {
    private final ApplicationContext appContext;

    @Autowired
    public CurrencyConverterApplication(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterApplication.class, args);
    }

}
