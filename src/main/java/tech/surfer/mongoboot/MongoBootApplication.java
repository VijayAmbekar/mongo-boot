package tech.surfer.mongoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoBootApplication.class, args);
	}

}
