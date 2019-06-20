package edu.mum.waa.backend.meditation.ws.entity;

import edu.mum.waa.backend.meditation.ws.entity.audit.IdDateAudit;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="TmAttendance", uniqueConstraints = @UniqueConstraint(columnNames ={"Student_Id","Card_Id","Date","Type"}))
//@SQLInsert(sql="Insert ignore into Tm_Attendance(student_id,card_id,date,type,location,name) values (?,?,?,?,?,?)")
public class TmAttendance extends IdDateAudit{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long sid;

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


    @Override
    public void setId(Long id) {
        this.sid = id;
    }
    @Override
    public long getId(){
        return this.sid;
    }
    @Override
    public boolean equals(Object obj) {
        TmAttendance attendanceEntity = (TmAttendance) obj;
        if (attendanceEntity == null) return false;
        Integer id = this.studentId == null ? 0 : this.studentId;
        Long card = this.cardId == null ? 0L : this.cardId;
        Integer id1 = attendanceEntity.studentId == null ? 0 : attendanceEntity.studentId;
        Long card1 = attendanceEntity.cardId == null ? 0L : attendanceEntity.cardId;
        return  id.equals(id1)
                && card.equals(card1)
                && this.date.equals(attendanceEntity.date)
                && this.type.equals(attendanceEntity.type);
    }

}
