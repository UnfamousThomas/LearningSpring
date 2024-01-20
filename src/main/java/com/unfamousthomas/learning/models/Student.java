package com.unfamousthomas.learning.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table
public class Student {

    @Id
    @SequenceGenerator(
       name = "student_sequence",
       sequenceName = "student_sequence",
       allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private LocalDateTime birth;


}
