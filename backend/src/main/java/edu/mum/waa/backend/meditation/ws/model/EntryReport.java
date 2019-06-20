package edu.mum.waa.backend.meditation.ws.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryReport {
    private Integer studentId;
    private Integer attended;
    private Integer required;
    private Double percentage;
    private Double bonusPoint;
}
