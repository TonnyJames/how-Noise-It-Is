package com.projetointegrador.hownoiseitis.controller;

import com.projetointegrador.hownoiseitis.entities.InfoDb;
import com.projetointegrador.hownoiseitis.services.DecibeisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receber-decibel-medido")
public class recebimentoControler {

    private DecibeisService decibeisService;

    public recebimentoControler(DecibeisService decibeisService) {
        this.decibeisService = decibeisService;
    }

    @PostMapping("/valor")
    public ResponseEntity<?> receberDecibeis(@RequestBody InfoDb infoDb) {
        try {
            return ResponseEntity.ok(decibeisService.salvarInfoDb(infoDb));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
