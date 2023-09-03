package com.cats.inventory;

import com.cats.inventory.repository.CatsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cats.inventory.model.Cats;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CatsInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatsInventoryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CatsRepository catsRepository) {

		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Cats>> typeReference = new TypeReference<>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/seedData.json");
			List<Cats> cats = mapper.readValue(inputStream, typeReference);
			catsRepository.saveAll(cats);

			System.out.println("Cats Saved!");
		};
	}

}
