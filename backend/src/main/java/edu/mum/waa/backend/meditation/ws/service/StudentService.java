package edu.mum.waa.backend.meditation.ws.service;

import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.model.AttendDetail;
import edu.mum.waa.backend.meditation.ws.model.AttendDetailReport;
import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import edu.mum.waa.backend.meditation.ws.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public AttendanceReport generateReportByStudentId(Integer studentId);
    public AttendanceReport generateReportByBlockId(Long blockId,Integer studentId);
    public AttendDetailReport getAttandDetail(Long blockId, Integer studentId);
}
