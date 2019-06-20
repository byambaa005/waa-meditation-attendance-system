package edu.mum.waa.meditation.gui.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AttendanceReport {
    private List<TmAttendance> attendanceList;
    private Integer attendence;
    private Integer requiredAttendance;
    private Double percentage;
    private Double extraPoint;
    public AttendanceReport(){
        attendanceList = new ArrayList<TmAttendance>();
    }

}
