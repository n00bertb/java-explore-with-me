package ru.practicum.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ru.practicum.statsclient", "ru.practicum.mainservice"})
public class MainServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(MainServiceApp.class, args);
    }
}
