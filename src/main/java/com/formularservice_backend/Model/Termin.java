package com.formularservice_backend.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.annotation.Collation;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class Termin {

    // Setter methods
    // Getter methods
    private String termindatum;
    private String terminuhrzeit;
}
