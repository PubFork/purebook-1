package com.purebook.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


//主程序。。
@SpringBootApplication
public class Demo1Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(Demo1Application.class);
//	}
}
