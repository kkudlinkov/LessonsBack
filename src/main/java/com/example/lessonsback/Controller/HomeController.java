package com.example.lessonsback.Controller;

import com.example.lessonsback.Service.TestsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
@AllArgsConstructor
public class HomeController {
    private final TestsService testsService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("films", testsService.getAllTests());

        model.addAttribute("isAuth", false);
        return "index";
    }
}
