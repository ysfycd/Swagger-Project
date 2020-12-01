package com.yusufyucedag.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yusufyucedag.swagger.dto.PetCreateDTO;
import com.yusufyucedag.swagger.service.PetService;

/**
 * 
 * @author Yusuf Yucedag
 * @since 1.0
 * @date 2020-Dec-01
 */
@SpringBootApplication
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialPet(PetService petService) {
		return (args) -> {

			PetCreateDTO pet = new PetCreateDTO();
			pet.setPetName("Bird");
			petService.createPet(pet);

			PetCreateDTO pet2 = new PetCreateDTO();
			pet2.setPetName("Cat");
			petService.createPet(pet2);

			PetCreateDTO pet3 = new PetCreateDTO();
			pet3.setPetName("Fish");
			petService.createPet(pet3);

		};
	}
}
