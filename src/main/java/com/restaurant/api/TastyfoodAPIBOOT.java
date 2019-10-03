package com.restaurant.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class TastyfoodAPIBOOT extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TastyfoodAPIBOOT.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TastyfoodAPIBOOT.class, args);
    }

}