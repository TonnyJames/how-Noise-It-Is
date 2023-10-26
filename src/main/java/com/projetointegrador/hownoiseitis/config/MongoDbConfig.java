package com.projetointegrador.hownoiseitis.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.projetointegrador.hownoiseitis")
@PropertySource("classpath:application.properties")
@Qualifier("mongoDbEntityManagerFactory")
public class MongoDbConfig {

    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.database}")
    private String dataBase;
    @Value("${spring.data.mongodb.port}")
    private String port;

    public String getDatabaseName() {
        return dataBase;
    }

    @Bean
    public MongoClient mongoClient() {
        ServerAddress address = new ServerAddress(host, Integer.parseInt(port));
        MongoClientOptions options = new MongoClientOptions.Builder().build();
        return new MongoClient(address, options);
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
