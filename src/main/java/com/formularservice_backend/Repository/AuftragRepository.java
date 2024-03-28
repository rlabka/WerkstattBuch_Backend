package com.formularservice_backend.Repository;

import com.formularservice_backend.Model.Auftrag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuftragRepository extends MongoRepository<Auftrag,String> {

}
