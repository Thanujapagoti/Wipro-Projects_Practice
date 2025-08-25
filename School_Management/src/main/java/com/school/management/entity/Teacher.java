package com.school.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherName;
    private String teacherAddress;

    @Enumerated(EnumType.STRING)
    private Qualification qualification;

    private int age;
    private LocalDate dob;
    private int experience;
}
