package edu.mum.waa.backend.meditation.ws.entity;

import edu.mum.waa.backend.meditation.ws.entity.audit.UserDateAudit;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
@Data
@Entity
public class TmRetreat extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Basic
    private long studentId;

    @Basic
    private Instant checkDate;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id= id;
    }
}
