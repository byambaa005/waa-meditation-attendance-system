package edu.mum.waa.meditation.gui.model;

import lombok.Data;

@Data
public class Student {
//    @Range(min=111, max=999, message ="Id must be in the range 111 to 999")
    public long studentId;

    private String firstName;

    private String lastName;

    private String  entry;

    public Student(Long studentId, String entry, String firstName, String lastName){
        this.studentId=studentId;
        this.entry=entry;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Student() {

    }
}
