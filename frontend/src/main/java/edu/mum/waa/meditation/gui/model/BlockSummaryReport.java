package edu.mum.waa.meditation.gui.model;

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
