package com.projetointegrador.hownoiseitis.repositories;

import com.projetointegrador.hownoiseitis.config.MongoDbConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoPersistence {

    private AnnotationConfigApplicationContext ctx;
    private final MongoTemplate mongoTemplate;

    public MongoPersistence() {
        this.ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDbConfig.class);
        ctx.refresh();
        this.mongoTemplate = ctx.getBean(MongoTemplate.class);
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}
