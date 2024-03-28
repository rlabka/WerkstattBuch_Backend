package com.formularservice_backend.Service;

import com.formularservice_backend.Model.Auftrag;
import com.formularservice_backend.Repository.AuftragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuftragService {

    private final AuftragRepository auftragRepository;

    @Autowired
    public AuftragService(AuftragRepository auftragRepository) {
        this.auftragRepository = auftragRepository;
    }

    public void saveAuftrag(Auftrag auftrag) {
        auftragRepository.save(auftrag);
    }
}
