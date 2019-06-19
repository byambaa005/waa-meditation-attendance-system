package edu.mum.waa.meditation.gui.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TmCheckResponse  {

    private LocalDate checkedDate;
    private String tmType;
    private Long id;
    private Student student;

    public TmCheckResponse() {

    }
}
