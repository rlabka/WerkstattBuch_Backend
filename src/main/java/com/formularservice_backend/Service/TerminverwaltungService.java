package com.formularservice_backend.Service;

import com.formularservice_backend.Model.TerminUhrzeit;
import com.formularservice_backend.Model.Terminverwaltung;
import com.formularservice_backend.Repository.TerminverwaltungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class TerminverwaltungService {

    @Autowired
    private TerminverwaltungRepository terminverwaltungRepository;

    private Terminverwaltung createNewTermin(String date) {

        List<TerminUhrzeit> termine = new ArrayList<>();
        termine.add(new TerminUhrzeit("08:30", false));
        termine.add(new TerminUhrzeit("09:00", false));
        termine.add(new TerminUhrzeit("09:30", false));
        termine.add(new TerminUhrzeit("10:00", false));
        termine.add(new TerminUhrzeit("10:30", false));
        termine.add(new TerminUhrzeit("11:00", false));
        termine.add(new TerminUhrzeit("11:30", false));
        termine.add(new TerminUhrzeit("12:00", false));
        termine.add(new TerminUhrzeit("12:30", false));
        termine.add(new TerminUhrzeit("13:00", false));
        termine.add(new TerminUhrzeit("13:30", false));
        termine.add(new TerminUhrzeit("14:00", false));
        termine.add(new TerminUhrzeit("14:30", false));
        termine.add(new TerminUhrzeit("15:00", false));
        termine.add(new TerminUhrzeit("15:30", false));
        termine.add(new TerminUhrzeit("16:00", false));
        termine.add(new TerminUhrzeit("16:30", false));
        termine.add(new TerminUhrzeit("17:00", false));
        termine.add(new TerminUhrzeit("17:30", false));
        termine.add(new TerminUhrzeit("18:00", false));
        termine.add(new TerminUhrzeit("18:30", false));
        termine.add(new TerminUhrzeit("19:00", false));
        termine.add(new TerminUhrzeit("19:30", false));

        Terminverwaltung terminverwaltung = new Terminverwaltung(date, termine);
        return terminverwaltungRepository.save(terminverwaltung);
    }
    private Terminverwaltung TerminSearch( String datum ){
        return terminverwaltungRepository.findByDatum(datum);
    }

    public Terminverwaltung checkTermin(String datum){
        if (TerminSearch(datum) == null) {
            LocalDate heute = LocalDate.now();
            if (LocalDate.parse(datum, DateTimeFormatter.ofPattern("d.M.yyyy")).isAfter(heute) || LocalDate.parse(datum, DateTimeFormatter.ofPattern("d.M.yyyy")).isEqual(heute)) {
                return createNewTermin(datum);
            }
        }
        return TerminSearch(datum);
    }

    private void deactivatePastTermine() {
        LocalDate heute = LocalDate.now();
        String todayDate = heute.format(DateTimeFormatter.ofPattern("d.M.yyyy"));
        Terminverwaltung terminverwaltung = terminverwaltungRepository.findByDatum(todayDate);
        if (terminverwaltung != null) {
            LocalTime currentTime = LocalTime.now();
            for (TerminUhrzeit terminUhrzeit : terminverwaltung.getTermine()) {
                LocalTime terminTime = LocalTime.parse(terminUhrzeit.getUhrzeit());
                if (terminTime.isBefore(currentTime)) {
                    terminUhrzeit.setStatus(false);
                }
            }
            terminverwaltungRepository.save(terminverwaltung);
        }
    }

    @Scheduled(cron = "0 */30 8-20 * * *")
    private void runTask() {
        this.deactivatePastTermine();
    }

}
