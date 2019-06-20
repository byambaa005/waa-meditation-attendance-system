package edu.mum.waa.meditation.gui.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
public class TmCheckNew {
    @PastOrPresent(message="Tm check date must be current or past")
    @NotNull(message = "Date must not be null")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate checkedDate;
    @NotBlank(message = "TM type must be chosen")
    private String tmType;
    private Student student;

    public TmCheckNew() {
    }

}
