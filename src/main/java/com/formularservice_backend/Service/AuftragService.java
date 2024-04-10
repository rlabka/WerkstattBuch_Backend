package com.formularservice_backend.Service;

import com.formularservice_backend.Model.Auftrag;
import com.formularservice_backend.Repository.AuftragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuftragService {

    private final AuftragRepository auftragRepository;
    private final TerminverwaltungService terminService; // Fügen Sie den TerminService hinzu, um Termine zu aktualisieren

    @Autowired
    public AuftragService(AuftragRepository auftragRepository, TerminverwaltungService terminService) {
        this.auftragRepository = auftragRepository;
        this.terminService = terminService;
    }

    public void saveAuftrag(Auftrag auftrag) {
        // Setzen Sie die nächsten zwei Termine auf true
        terminService.setNextThreeTermineTrue(auftrag.getTermin().getTermindatum(), auftrag.getTermin().getTerminuhrzeit(),auftrag.getKundeinformationen().getAuswahl());
        auftragRepository.save(auftrag);
    }

    public List<Auftrag> getallAuftraege() {
        return auftragRepository.findAll();
    }
}
