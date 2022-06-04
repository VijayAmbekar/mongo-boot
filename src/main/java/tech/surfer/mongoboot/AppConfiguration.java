package tech.surfer.mongoboot;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

//    @Value("#{spring.data.mongodb.uri}")
//    private String connectionStr;
//
//    @Bean
//    public MongoClientSettings mongoClientSettings() {
//        ConnectionString connectionString = new ConnectionString(connectionStr);
//
//        return MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .serverApi(ServerApi.builder()
//                        .version(ServerApiVersion.V1)
//                        .build())
//                .build();
//    }
//
//    @Bean
//    public MongoClient mongoClient(MongoClientSettings mongoClientSettings) {
//        return MongoClients.create(mongoClientSettings);
//    }
}
