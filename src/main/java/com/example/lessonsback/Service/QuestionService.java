package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.model.Question;
import com.example.lessonsback.Domain.model.Test;
import com.example.lessonsback.Repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    /**
     * Получение всех тестов
     *
     * @return
     */
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Optional<Question> findById(int id) {
        return questionRepository.findById(id);
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Question getById(int id) {
        return findById(id).orElseThrow();
    }

    public void save(Question question) {
        questionRepository.save(question);
    }

}
