package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tangj
 * @date 2018/9/9 23:35
 */
@SpringBootApplication
public class StartApplication {

    public static void main(String args[]){
        new SpringApplication(StartApplication.class).run(args);
    }
}
