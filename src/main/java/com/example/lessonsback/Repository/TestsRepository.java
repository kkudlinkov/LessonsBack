package com.example.lessonsback.Repository;


import com.example.lessonsback.Domain.model.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<Tests, Integer> {

}