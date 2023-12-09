package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.dto.SubmitQuestion;
import com.example.lessonsback.Domain.dto.SubmitTestDTO;
import com.example.lessonsback.Domain.dto.TestPassData;
import com.example.lessonsback.Domain.model.Answer;
import com.example.lessonsback.Domain.model.Attempt;
import com.example.lessonsback.Domain.model.Test;
import com.example.lessonsback.Repository.AttemptRepository;
import com.example.lessonsback.Repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository repository;
    private final AttemptRepository attemptRepository;
    private final QuestionService questionService;
    private final AuthService authService;

    /**
     * Получение всех тестов
     *
     * @return
     */
    public List<Test> getAllTests(){
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Optional<Test> findById(int id) {
        return repository.findById(id);
    }

    /**
     * Получение конкретного фильма
     *
     * @return
     */
    public Test getById(int id) {
        return findById(id).orElseThrow();
    }


    public void submitTest(Integer testId, SubmitTestDTO request) {
        // Тут создаём коннектор
        var test = getById(testId);

        var user = authService.getAuthUser().orElseThrow();

        // Получаем все вопросы по id

        // Создаём экхемпляр попытки
        Attempt attempt = new Attempt();
        attempt.setAnswers(new ArrayList<>());
        attempt.setTest(test);
        attempt.setUser(user);


        for (var q : request.getQuestions()) {
            var question = questionService.getById(q.getQuestionId());
            // проверяем, что вопрос принадлежит тесту
            if (question.getTest().getId() != testId) {
                throw new RuntimeException("Error");
            }
            // Проверяем что ответ правильный
            // Если правильный, то добавляем в попытку объект ответа на вопрос
            var answer = new Answer();
            answer.setAttempt(attempt);
            answer.setQuestion(question);
            answer.setIsCorrect(Integer.valueOf(q.getSelectedAnswer()).equals(question.getCorrectAnswer()));
            attempt.getAnswers().add(answer);

            System.out.println(q.getSelectedAnswer() + " " + question.getCorrectAnswer());
            //вычисляем сумму баллов правильных ответов
            System.out.println(attempt.getAnswers().stream().filter(Answer::getIsCorrect).count());

        }

        // Проверка на удачную попытку (Набранные баллы >= Проходного балла в тесте)
        // Проверка на удачную попытку (Все набранные баллы >= Проходного балла в тесте)

        attempt.setIsSuccess(attempt.getAnswers().stream().filter(Answer::getIsCorrect).count() >= test.getMinGrade());
        // Вывод сообщение о результате попытки
        System.out.println(attempt.getIsSuccess() ? "Успешно" : "Не успешно");
        // Сохраняем попытку
        attemptRepository.save(attempt);
    }

    public TestPassData isPassed(int id) {
        var test = getById(id);
        var user = authService.getAuthUser().orElseThrow();

        var attemps = attemptRepository.findAllByTestIdAndUserId(test.getId(), user.getId());

        return TestPassData.builder()
                .isSuccess(attemps.stream().anyMatch(Attempt::getIsSuccess))
                .tries(attemps.size())
                .build();
    }

    public void save(Test test) {
        repository.save(test);
    }
}
