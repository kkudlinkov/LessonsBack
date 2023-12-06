package com.example.lessonsback.Repository;


import com.example.lessonsback.Domain.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
}
