package edu.mum.waa.backend.meditation.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Data
@AllArgsConstructor
public class BlockSummaryReport {
    private List<EntryReport> attendanceList;
    public BlockSummaryReport(){
        attendanceList = new ArrayList<>();
    }
}
