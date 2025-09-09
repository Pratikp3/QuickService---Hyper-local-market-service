package com.hyper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.hyper") //Ensures Spring finds all your @RestController, @Service, @Component, etc.
@EnableJpaRepositories(basePackages = "com.hyper.repository") //Ensures JPA scans your @Entity classes.
@EntityScan(basePackages = "com.hyper.pojo") //Ensures Spring Data scans your JpaRepository interfaces.
public class ServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }
}
