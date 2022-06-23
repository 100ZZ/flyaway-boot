package com.lihuia.flyaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lihuia.com
 * @date 2022/6/21 10:17 AM
 */

@SpringBootApplication
public class FlyawayApplication {


    public static void main(String[] args) {
        try {
            SpringApplication.run(FlyawayApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----------Flyaway-----------");
    }
}
