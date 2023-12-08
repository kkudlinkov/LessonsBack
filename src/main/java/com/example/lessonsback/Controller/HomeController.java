package com.example.lessonsback.Controller;

import com.example.lessonsback.Domain.model.Attempt;
import com.example.lessonsback.Service.AuthService;
import com.example.lessonsback.Service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@AllArgsConstructor
public class HomeController {
    private final TestService testService;
    private final AuthService authService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("test", testService.getAllTests());

        // Провряем, авторизован ли пользователь добавляя переменную isAuth
        model.addAttribute("isAuth", authService.getAuthUser().isPresent());

        // Если пользователь авторизован, то добавляем его в модель
        authService.getAuthUser().ifPresent(user -> model.addAttribute("user", user));
        return "index";
    }
}
