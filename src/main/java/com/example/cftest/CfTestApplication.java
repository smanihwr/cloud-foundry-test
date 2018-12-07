package com.example.cftest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CfTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfTestApplication.class, args);
    }

    @Value("${test.prop1}")
    private String test;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationLoad() {
        System.out.println(test);
        System.out.println(" ****************************************************************** ");
        System.out.println(" *********************** Application loaded *********************** ");
        System.out.println(" ****************************************************************** ");
    }
}
