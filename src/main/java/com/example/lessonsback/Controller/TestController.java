package com.example.lessonsback.Controller;

import com.example.lessonsback.Service.AuthService;
import com.example.lessonsback.Service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
