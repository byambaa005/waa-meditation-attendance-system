package edu.mum.waa.meditation.gui.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TM {


    private  long id;
    private LocalDate checkedDate;

    private LocalDate updatedDate;

    private String tmType;

    private String studentId;

    public TM() {

    }
}
