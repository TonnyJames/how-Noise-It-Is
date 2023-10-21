package com.projetointegrador.hownoiseitis.repositories;

import com.projetointegrador.hownoiseitis.entities.InfoDb;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class MongoEventsRepository extends MongoPersistence {

    @Transactional
    public Object salvarDecibeis (InfoDb infoDb) {
        return getMongoTemplate().save(infoDb, "infoDecibeis");
    }

}
