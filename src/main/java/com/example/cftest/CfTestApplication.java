package com.example.cftest;

import com.example.cftest.model.Student;
import com.example.cftest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StudentRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationLoad() {
        System.out.println(" ****************************************************************** ");
        System.out.println(" *********************** Application loaded *********************** ");
        System.out.println(" ****************************************************************** ");

        repository.save(Student.builder()
                .id(1L)
                .name("Dave").build());

        repository.save(Student.builder()
                .id(2L)
                .name("Mike").build());
    }
}
