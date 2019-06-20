package edu.mum.waa.backend.meditation.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendDetail {
    String date;
    Boolean attended;
}
