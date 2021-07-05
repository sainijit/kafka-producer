package com.intel.devclout.gen2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class Application{

	@Autowired
	static ResourceLoader resourceLoader;

	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}
}
