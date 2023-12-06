package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.model.Answer;
import com.example.lessonsback.Domain.model.Attempt;
import com.example.lessonsback.Repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    /**
     * Получение всех тестов
     *
     * @return
     */
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Optional<Answer> findById(int id) {
        return answerRepository.findById(id);
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Answer getById(int id) {
        return findById(id).orElseThrow();
    }
}
