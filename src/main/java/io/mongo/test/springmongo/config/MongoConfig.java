package io.mongo.test.springmongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;


@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String uri;
    @Bean
    public MongoTemplate mongoTemplate(
            SimpleMongoClientDatabaseFactory mongoClientDatabaseFactory
    ) {
        return new MongoTemplate(mongoClientDatabaseFactory);
    }
    @Bean
    public SimpleMongoClientDatabaseFactory simpleMongoClientDatabaseFactory() {
        return new SimpleMongoClientDatabaseFactory(uri);
    }

    @Bean
    public MongoTransactionManager mongoTransactionManager(
            SimpleMongoClientDatabaseFactory mongoClientDatabaseFactory
    ) {

        return new MongoTransactionManager(mongoClientDatabaseFactory);
    }
}
