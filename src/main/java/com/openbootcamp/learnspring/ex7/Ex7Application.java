package com.openbootcamp.learnspring.ex7;

import org.springdoc.core.RequestBodyInfo;
import org.springdoc.core.RequestBodyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.DispatcherServlet;

import javax.swing.*;

@SpringBootApplication
public class Ex7Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex7Application.class, args);
        DispatcherServlet disp = new DispatcherServlet();
    }

}
