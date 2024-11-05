package com.formularservice_backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auftragsnummern")

public class Auftragsnummer {

    @Id
    private String id;
    private Long nummer;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Long getNummer() {
        return nummer;
    }

    public void setNummer(Long nummer) {
        this.nummer = nummer;
    }
}