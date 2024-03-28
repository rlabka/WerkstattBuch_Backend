package com.formularservice_backend.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Autoinformationen {
    private String automarke;
    private String fahrzeugtyp;
    private String reifengroesse;
    private String radgroesse;
    private String raederart;
    private Integer anzahlreifen;
}
