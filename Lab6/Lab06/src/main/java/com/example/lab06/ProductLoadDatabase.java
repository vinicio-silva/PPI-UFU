package com.example.lab06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductLoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(ProductLoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabaseProduct(ProductRepository repository){
		return args -> {
			log.info("Preloading" + repository.save(new Product("Banana", 100)));
			log.info("Preloading" + repository.save(new Product("Pera", 140)));
			log.info("Preloading" + repository.save(new Product("Uva", 100)));
		};
	}
}