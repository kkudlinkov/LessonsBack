package com.example.lessonsback.Repository;


import com.example.lessonsback.Domain.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
