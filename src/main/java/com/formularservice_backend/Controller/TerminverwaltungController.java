package com.formularservice_backend.Controller;
import com.formularservice_backend.Model.Termin;
import com.formularservice_backend.Model.TerminUhrzeit;
import com.formularservice_backend.Model.Terminverwaltung;
import com.formularservice_backend.Service.TerminverwaltungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/terminverwaltung")
public class TerminverwaltungController {

    @Autowired
    private TerminverwaltungService terminverwaltungService;

    @GetMapping("/get")
    public ResponseEntity<?> GetTermin(@RequestParam("date") String date) {
        // Überprüfen, ob das angegebene Datum ungültig ist
        LocalDate today = LocalDate.now();
        LocalDate requestedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d.M.yyyy"));
        if (requestedDate.isBefore(today)) {
            return new ResponseEntity<>("Das angegebene Datum liegt in der Vergangenheit.", HttpStatus.BAD_REQUEST);
        }

        Terminverwaltung terminverwaltung = terminverwaltungService.checkTermin(date);
        if (terminverwaltung == null) {
            return new ResponseEntity<>("Es wurden keine Termine für das angegebene Datum gefunden.", HttpStatus.NOT_FOUND);
        }

        List<TerminUhrzeit> checkTermin = terminverwaltung.getTermine();
        return new ResponseEntity<>(checkTermin, HttpStatus.OK);
    }
}
