package com.louyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan({"com.louyi.system.hr.dao",
			 "com.louyi.modules.app.dao",
			 "com.louyi.modules.job.dao",
			 "com.louyi.modules.oss.dao",
			 "com.louyi.modules.sys.dao"})
@SpringBootApplication
public class LouYiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LouYiApplication.class, args);
	}

}