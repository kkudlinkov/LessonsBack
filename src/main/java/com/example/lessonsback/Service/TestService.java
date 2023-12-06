package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.model.Test;
import com.example.lessonsback.Repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    /**
     * Получение всех тестов
     *
     * @return
     */
    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Optional<Test> findById(int id) {
        return testRepository.findById(id);
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Test getById(int id) {
        return findById(id).orElseThrow();
    }
}
