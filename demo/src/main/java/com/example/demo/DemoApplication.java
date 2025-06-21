package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("KIS_APP_KEY", dotenv.get("KIS_APP_KEY"));
		System.setProperty("KIS_APP_SECRET", dotenv.get("KIS_APP_SECRET"));
		SpringApplication.run(DemoApplication.class, args);
	}

}
