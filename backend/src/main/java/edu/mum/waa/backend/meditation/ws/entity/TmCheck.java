package edu.mum.waa.backend.meditation.ws.entity;

import edu.mum.waa.backend.meditation.ws.entity.audit.UserDateAudit;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
public class TmCheck extends UserDateAudit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @PastOrPresent(message="Tm check date must be current or past")
    @NotNull(message = "Date must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkedDate;

    @NotBlank(message = "TM type must be chosen")
    private String tmType;

    @Valid
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id= id;
    }
}
