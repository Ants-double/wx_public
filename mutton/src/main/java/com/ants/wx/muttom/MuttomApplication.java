package com.ants.wx.muttom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MuttomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuttomApplication.class, args);
    }

}
