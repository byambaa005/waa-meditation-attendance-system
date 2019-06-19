package edu.mum.waa.backend.meditation.ws.model;

import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

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
