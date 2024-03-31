package com.formularservice_backend.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "termine")
public class Terminverwaltung {
    @Id
    private String id;

    private String datum;

    private List<TerminUhrzeit> termine;

    public Terminverwaltung(String date, List<TerminUhrzeit> termine) {
        this.termine=termine;
        this.datum=date;
    }
}
