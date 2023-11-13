package com.projetointegrador.hownoiseitis.repositories;

import com.projetointegrador.hownoiseitis.entities.InfoDb;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public class MongoEventsRepository extends MongoPersistence {

    @Transactional
    public Object salvarDecibeis (InfoDb infoDb) {
        return getMongoTemplate().save(infoDb, "infoDecibeis");
    }

    public Object consultarUltimasMedicoes() {

        LocalDateTime horaAtual = LocalDateTime.now();

        LocalDateTime dataHoraModificado = horaAtual.minusDays(2);

        Query query = new Query().addCriteria(Criteria.where("data").gte(dataHoraModificado).lte(horaAtual));

        return getMongoTemplate().find(query, InfoDb.class, "infoDecibeis");

    }

    public Object consultarUltimaMedicao() {

        Query query = new Query();
        query.limit(1);
        query.with(Sort.by(Sort.Direction.DESC,"_id"));
        return getMongoTemplate().findOne(query, InfoDb.class, "infoDecibeis");
    }
}
