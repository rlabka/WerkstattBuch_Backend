package com.formularservice_backend.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "auftrag")
public class Auftrag {

    @Id
    private String id;

    private Long auftragsnummer;

    private Kundeinformationen kundeinformationen;

    private Autoinformationen autoinformationen;

    private Date timestamp;

    private Termin termin;
}