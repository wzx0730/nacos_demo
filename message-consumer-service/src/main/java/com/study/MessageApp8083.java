package com.study;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MessageApp8083 {
    public static void main(String[] args) {
        SpringApplication.run(MessageApp8083.class, args);
    }
}
