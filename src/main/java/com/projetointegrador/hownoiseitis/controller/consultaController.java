package com.projetointegrador.hownoiseitis.controller;

import com.projetointegrador.hownoiseitis.services.DecibeisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultar-medicoes")
public class consultaController {

    private DecibeisService decibeisService;

    public consultaController(DecibeisService decibeisService) {
        this.decibeisService = decibeisService;
    }

    @GetMapping("/inicial")
    public ResponseEntity<?> consultarUltimasMedicoes() {
        try {
            return ResponseEntity.ok(decibeisService.consultarUtimasMedicoes());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ultima")
    public ResponseEntity<?> ultimaMedicao() {
        try {
            return ResponseEntity.ok(decibeisService.consultarUltimaMedicao());
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
