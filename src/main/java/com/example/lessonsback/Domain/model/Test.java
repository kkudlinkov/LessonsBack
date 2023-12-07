package com.example.lessonsback.Domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String testName;

    @Column(name = "desc")
    private String desc;

    @Column(name = "min_grade")
    private int minGrade;

    @OneToMany(mappedBy = "test")
    private List<Question> questions;
}
