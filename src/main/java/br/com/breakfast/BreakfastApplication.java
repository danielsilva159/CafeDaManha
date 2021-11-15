package br.com.breakfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.breakfast.model")
@SpringBootApplication
public class BreakfastApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(BreakfastApplication.class, args);
		
	}

}
