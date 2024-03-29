package com.formularservice_backend.Service;

import com.formularservice_backend.Model.Auftrag;
import com.formularservice_backend.Model.Auftragsnummer;
import com.formularservice_backend.Repository.AuftragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class AuftragService {

    private final AuftragRepository auftragRepository;
    private final MongoTemplate mongoTemplate;
    private static final String AUFTRAGSNUMMER_COLLECTION = "auftragsnummern";

    @Autowired
    public AuftragService(AuftragRepository auftragRepository, MongoTemplate mongoTemplate) {
        this.auftragRepository = auftragRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void saveAuftrag(Auftrag auftrag) {
        auftrag.setAuftragsnummer(this.getNextAuftragsnummer());
        auftragRepository.save(auftrag);
    }
    public List<Auftrag> getallAuftraege() {
        return auftragRepository.findAll();
    }

    public Long getNextAuftragsnummer() {
        // Suchen Sie die aktuelle Auftragsnummer in der Sammlung
        Auftragsnummer auftragsnummer = mongoTemplate.findById("current", Auftragsnummer.class, AUFTRAGSNUMMER_COLLECTION);

        // Wenn keine Auftragsnummer vorhanden ist, legen Sie eine neue an
        if (auftragsnummer == null) {
            auftragsnummer = new Auftragsnummer();
            auftragsnummer.setId("current");
            auftragsnummer.setNummer(100L); // Startwert für die Auftragsnummer
            mongoTemplate.save(auftragsnummer, AUFTRAGSNUMMER_COLLECTION);
        }

        // Inkrementiere die Auftragsnummer und aktualisiere sie in der Sammlung
        return Objects.requireNonNull(mongoTemplate.findAndModify(
                query(where("_id").is("current")),
                new Update().inc("nummer", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Auftragsnummer.class,
                AUFTRAGSNUMMER_COLLECTION
        )).getNummer();
    }
}
