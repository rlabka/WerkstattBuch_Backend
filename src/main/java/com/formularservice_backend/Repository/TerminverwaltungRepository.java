package com.formularservice_backend.Repository;

import com.formularservice_backend.Model.Terminverwaltung;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminverwaltungRepository extends MongoRepository<Terminverwaltung,Long> {
    Terminverwaltung findByDatum(String datum);
}
