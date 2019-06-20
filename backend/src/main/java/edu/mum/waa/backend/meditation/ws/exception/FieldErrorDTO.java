package edu.mum.waa.backend.meditation.ws.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorDTO {

    private String field;
    private String message;
}
