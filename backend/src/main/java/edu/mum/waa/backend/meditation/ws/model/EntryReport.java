package edu.mum.waa.backend.meditation.ws.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntryReport {
    private Integer studentId;
    private Integer attended;
    private Integer required;
    private Double percentage;
    private Double bonusPoint;
}
