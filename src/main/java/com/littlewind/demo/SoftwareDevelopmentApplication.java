package com.littlewind.demo;

import java.awt.EventQueue;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.littlewind.demo.ui.LoginScreen;

@SpringBootApplication()
public class SoftwareDevelopmentApplication {

    public static void main(String[] args) {

    	ConfigurableApplicationContext ctx = new SpringApplicationBuilder(LoginScreen.class)
                .headless(false).run(args);
    	
//    	String[] allBeanNames = ctx.getBeanDefinitionNames();
//        System.out.println(allBeanNames.length);
//        for(String beanName : allBeanNames) {
//            System.out.println(beanName);
//        }

        EventQueue.invokeLater(() -> {
        	LoginScreen ex = ctx.getBean(LoginScreen.class);
            ex.setVisible(true);
        });
    }
    
}
