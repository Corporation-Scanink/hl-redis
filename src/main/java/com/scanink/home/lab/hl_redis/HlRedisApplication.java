package com.scanink.home.lab.hl_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class HlRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlRedisApplication.class, args);
	}

}
