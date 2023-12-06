package com.example.lessonsback.Domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "test_name")
    private String test_name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "min_grade")
    private int min_grade;
}
