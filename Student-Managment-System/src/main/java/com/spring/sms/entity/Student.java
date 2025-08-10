package com.spring.sms.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roll_no", nullable = false, unique = true)
    private String rollNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;
}
