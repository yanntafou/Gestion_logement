package com.lsd.logement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lsd.logement.repository")
@EntityScan(basePackages = "com.lsd.logement.entity")
@ComponentScan(basePackages = "com.lsd.logement")
public class LogementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogementApplication.class, args);
    }

}
