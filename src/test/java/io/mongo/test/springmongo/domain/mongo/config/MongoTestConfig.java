package io.mongo.test.springmongo.domain.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

@EnableMongoAuditing
@TestConfiguration
public class MongoTestConfig {

    @Bean
    public MongoClient mongo(){
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Primary
    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongo(), "test");
    }
}
