package edu.mum.waa.meditation.gui.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Block {

    private Long blockId;
    private String name;
    private String course;
    private String professorName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer totalDate;

    public Block() {

    }
}

