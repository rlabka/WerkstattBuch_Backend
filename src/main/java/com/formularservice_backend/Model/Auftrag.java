package com.formularservice_backend.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@Document(collection = "auftrag")
public class Auftrag {

    // Getter and Setter methods
    @Id
    private String id;

    private Long auftragsnummer;

    private Kundeinformationen kundeinformationen;

    private Autoinformationen autoinformationen;

    private Date timestamp;

    private Termin termin;

}
