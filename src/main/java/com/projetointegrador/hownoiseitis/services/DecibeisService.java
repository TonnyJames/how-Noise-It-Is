package com.projetointegrador.hownoiseitis.services;

import com.projetointegrador.hownoiseitis.entities.InfoDb;
import com.projetointegrador.hownoiseitis.repositories.MongoEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecibeisService {

    private MongoEventsRepository mongoEventsRepository;

    @Autowired
    public DecibeisService(MongoEventsRepository mongoEventsRepository) {
        this.mongoEventsRepository = mongoEventsRepository;
    }


    public Object salvarInfoDb(InfoDb infoDb){
        return mongoEventsRepository.salvarDecibeis(infoDb);
    }

    public Object consultarUtimasMedicoes() {
        return mongoEventsRepository.consultarUltimasMedicoes();
    }

    public Object consultarUltimaMedicao() {
        return mongoEventsRepository.consultarUltimaMedicao();
    }
}
