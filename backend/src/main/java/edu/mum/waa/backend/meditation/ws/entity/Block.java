package edu.mum.waa.backend.meditation.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.mum.waa.backend.meditation.ws.utils.Common;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Block")
public class Block {
    @Id
//    @Column(name="block_Id", nullable = false)
    private Integer blockId;
    private String name;
    private String course;
    private String professorName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer totalDate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "blocks")
    private Set<Student> students = new HashSet<>();

    public Block(Integer blockId, String name, String course, String professorName, LocalDate startDate, LocalDate endDate) {
        this.blockId = blockId;
        this.name = name;
        this.course = course;
        this.professorName = professorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDate = Common.calcWeekDays(startDate, endDate);
    }

}

