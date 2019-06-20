package edu.mum.waa.meditation.gui.model;

import lombok.Data;

import java.util.List;

@Data
public class StudentAttendanceResponse {

    private List<TmAttendance> attendanceList;
    private Integer attendence;
    private Integer requiredAttendance;
    private Double percentage;
    private Double extraPoint;

    public StudentAttendanceResponse() {

    }
}
