package edu.mum.waa.backend.meditation.ws.entity;

import edu.mum.waa.backend.meditation.ws.utils.Common;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Block {

    @Id
    @Column(name="blockId", nullable = false)
    private Integer blockId;
    private String name;
    private String course;
    private Integer professorId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer totalDate;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "blocks")
    private Set<User> users = new HashSet<>();

    public Block(Integer blockId, String name, String course, Integer professorId, LocalDate startDate, LocalDate endDate) {
        this.blockId = blockId;
        this.name = name;
        this.course = course;
        this.professorId = professorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDate = Common.calcWeekDays(startDate, endDate);
    }

}

