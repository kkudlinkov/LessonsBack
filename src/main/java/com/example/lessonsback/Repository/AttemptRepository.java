package com.example.lessonsback.Repository;


import com.example.lessonsback.Domain.model.Attempt;
import com.example.lessonsback.Domain.model.Test;
import com.example.lessonsback.Domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    boolean existsByTestIdAndUserIdAndAndIsSuccess(Integer testId, Integer userId, Boolean iSuccess);

    List<Attempt> findAllByTestIdAndUserId(Integer testId, Integer userId);

    //    boolean existByTestIdAndUserIdAndIsSuccess(int id, int id1, boolean b);
}
