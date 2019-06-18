package edu.mum.waa.backend.meditation.ws.entity;

import edu.mum.waa.backend.meditation.ws.entity.audit.IdDateAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TmAttendance", uniqueConstraints = {@UniqueConstraint(columnNames ={"Student_Id","Card_Id","Date","Type"})})
public class TmAttendance{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Student_Id")
    private Integer studentId;


    @Column(name = "Card_Id")
    private Long cardId;

    @Past
    @Column(name = "Date")
    private LocalDate date;

    @NotNull
    @Column(name = "Type")
    private String type;

    @Column(name = "Location")
    private String location;


    @Column(name = "Name")
    private String name;

    public TmAttendance(LocalDate date,Integer studentId, String type, String name) {
        this.studentId = studentId;
        this.date = date;
        this.type = type;
        this.name = name;
    }

    public TmAttendance(Long cardId, Integer studentId, LocalDate date, String type, String location) {
        this.cardId = cardId;
        this.studentId=studentId;
        this.date = date;
        this.type = type;
        this.location = location;
    }

    public TmAttendance(Integer studentId, Long cardId, LocalDate date, String type, String location) {
        this.studentId = studentId;
        this.cardId = cardId;
        this.date = date;
        this.type = type;
        this.location = location;
    }


//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
//    @Override
//    public long getId(){
//        return this.id;
//    }
}
