package com.formularservice_backend.Repository;

import com.formularservice_backend.Model.Auftrag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuftragRepository extends MongoRepository<Auftrag,String> {
    Auftrag findByAuftragsnummer(Long auftragsnummer);
}
