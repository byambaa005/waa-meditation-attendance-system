package edu.mum.waa.backend.meditation.ws.service;

import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.model.EntryReport;

import java.util.List;

public interface UserService {
    public AttendanceReport generateReportByBlockId(Long blockId);
    public List<EntryReport> generateReportByEntry(String entry);

}
