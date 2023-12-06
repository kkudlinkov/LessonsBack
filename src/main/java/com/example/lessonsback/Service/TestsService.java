package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.model.Tests;
import com.example.lessonsback.Repository.TestsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestsService {
    private final TestsRepository testsRepository;

    /**
     * Получение всех тестов
     *
     * @return
     */
    public List<Tests> getAllTests(){
        return testsRepository.findAll();
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Optional<Tests> findById(int id) {
        return testsRepository.findById(id);
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Tests getById(int id) {
        return findById(id).orElseThrow();
    }
}
