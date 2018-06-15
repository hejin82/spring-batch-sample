package org.hejin.spring.boot.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableTask
public class SpringBootBatchSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBatchSimpleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return strings -> System.out
                .println("Executed at :" + new SimpleDateFormat().format(new Date()));
    }
}
