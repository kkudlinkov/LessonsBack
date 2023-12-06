package com.example.lessonsback.Domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "second_answer")
    private String secondAnswer;

    @Column(name = "third_answer")
    private String thirdAnswer;

    @Column(name = "fourth_answer")
    private String fourthAnswer;

    @Column (name = "score")
    private String score;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

}
