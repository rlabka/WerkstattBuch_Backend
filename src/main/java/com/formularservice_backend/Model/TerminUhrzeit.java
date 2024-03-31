package com.formularservice_backend.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
public class TerminUhrzeit {
    private String uhrzeit;
    private boolean status;

    public TerminUhrzeit(String uhrzeit, boolean status) {
        this.uhrzeit = uhrzeit;
        this.status = status;
    }
}
