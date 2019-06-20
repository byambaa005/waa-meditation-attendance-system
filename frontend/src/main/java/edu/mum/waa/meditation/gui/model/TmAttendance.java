package edu.mum.waa.meditation.gui.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TmAttendance{
    private Long sid;
    private Integer studentId;
    private Long cardId;
    private LocalDate date;
    private String type;
    private String location;
    private String name;

    public TmAttendance() {

    }

}
