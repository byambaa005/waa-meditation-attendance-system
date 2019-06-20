package edu.mum.waa.backend.meditation.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Data
@AllArgsConstructor
public class AttendDetailReport {
    private List<AttendDetail> attendanceList;
    private Integer attendence;
    private Integer requiredAttendance;
    private Double percentage;
    private Double extraPoint;
    public AttendDetailReport(){
        attendanceList = new ArrayList<>();
    }
}
