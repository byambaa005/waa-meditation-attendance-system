package edu.mum.waa.backend.meditation.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Student {
//    @Range(min=111, max=999, message ="Id must be in the range 111 to 999")
    @Id
    public Integer studentId;

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="Entry")
    private String  entry;
    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL )
    private List<TmCheck> tmCheckList;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

//    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_blocks",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "block_id"))
    private Set<Block> blocks = new HashSet<>();

    public Student(Integer studentId, String entry, String firstName, String lastName){
        this.studentId=studentId;
        this.entry=entry;
        this.firstName=firstName;
        this.lastName=lastName;
    }



    public Student() {

    }
}
