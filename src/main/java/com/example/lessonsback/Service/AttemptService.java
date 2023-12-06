package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.model.Attempt;
import com.example.lessonsback.Domain.model.Question;
import com.example.lessonsback.Repository.AttemptRepository;
import com.example.lessonsback.Repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttemptService {
    private final AttemptRepository attemptRepository;

    /**
     * Получение всех тестов
     *
     * @return
     */
    public List<Attempt> getAllQuestions() {
        return attemptRepository.findAll();
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Optional<Attempt> findById(int id) {
        return attemptRepository.findById(id);
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Attempt getById(int id) {
        return findById(id).orElseThrow();
    }
}
