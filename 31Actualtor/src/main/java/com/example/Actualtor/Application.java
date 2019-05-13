package com.example.Actualtor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {


		SpringApplication.run(Application.class, args);
	}

	//we cant map / mapping for rest-hal-browser
	//http://localhost:9090/app/

	/*@RequestMapping("/")
	public String Hello(){
		return "Hello";
	}*/


}
