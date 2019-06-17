package edu.mum.waa.backend.meditation.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 */
@Data
@AllArgsConstructor
public class ApiResponse {
    private Boolean success;
    private String message;
}
