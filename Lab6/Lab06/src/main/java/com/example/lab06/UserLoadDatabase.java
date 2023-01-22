package com.example.lab06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserLoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(UserLoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(UserRepository repository){
		return args -> {
			log.info("Preloading" + repository.save(new Users("SteveJobs", "steve@apple.com")));
			log.info("Preloading" + repository.save(new Users("Billgates", "bill@ms.com")));
			log.info("Preloading" + repository.save(new Users("ElonMusk", "elon@tesla.com")));
		};
	}
}