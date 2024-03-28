package com.formularservice_backend.Controller;

import com.formularservice_backend.Model.Auftrag;
import com.formularservice_backend.Service.AuftragService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auftrag")
public class AuftragController {

    private final AuftragService auftragService;

    @Autowired
    public AuftragController(AuftragService auftragService) {
        this.auftragService = auftragService;
    }

    @PostMapping("/neu")
    public ResponseEntity<String> createAuftrag(@RequestBody Auftrag auftrag) {
        auftragService.saveAuftrag(auftrag);
        return new ResponseEntity<>("Auftrag erfolgreich erstellt", HttpStatus.CREATED);
    }
}
