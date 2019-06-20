package edu.mum.waa.meditation.gui.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TmCheckResponse  {
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate checkedDate;
    private String tmType;
    private Long id;
    private Student student;

    public TmCheckResponse() {
    }

}
