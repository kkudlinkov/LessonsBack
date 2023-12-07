package com.example.lessonsback.Controller;

import com.example.lessonsback.Domain.dto.SubmitTestDTO;
import com.example.lessonsback.Domain.model.Question;
import com.example.lessonsback.Service.AuthService;
import com.example.lessonsback.Service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private final TestService testService;
    private final AuthService authService;

    /**
     * Получение конкретного фильма
     * @return
     */
    @GetMapping("/{id}")
    public String getTest(
            @PathVariable("id") int id,
            Model model
    ) {

        // Провряем, авторизован ли пользователь добавляя переменную isAuth
        model.addAttribute("isAuth", authService.getAuthUser().isPresent());

        // Если пользователь авторизован, то добавляем его в модель
        authService.getAuthUser().ifPresent(user -> model.addAttribute("user", user));

        // Проверка на существование продукта
        var test = testService.getById(id);
        if (test == null) {
            return "redirect:/error";
        }
        model.addAttribute("test", test);
        return "test";
    }

    @PostMapping("/test-submit/{testId}")
    public String submitTest(
            @ModelAttribute("submitTestDTO") SubmitTestDTO request,
            @PathVariable("testId") Integer testId
    ) {
        testService.submitTest(testId, request);
//        System.out.println(testId);
//        System.out.println(submitTestDTO);
//        List<Question> answers = submitTestDTO.getQuestions();
//        for (Question answer : answers) {
//            System.out.println(answer);
//        }
        return "redirect:/"; // Замените "result-page" на имя вашей страницы с результатами
    }
}
