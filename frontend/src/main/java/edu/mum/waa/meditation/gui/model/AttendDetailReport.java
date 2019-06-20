package edu.mum.waa.meditation.gui.model;

import lombok.Data;

import java.util.List;

/**
 */
@Data
public class AttendDetailReport {
    private List<AttendDetail> attendanceList;
    private Integer attendence;
    private Integer requiredAttendance;
    private Double percentage;
    private Double extraPoint;
    public AttendDetailReport(){

    }
}
