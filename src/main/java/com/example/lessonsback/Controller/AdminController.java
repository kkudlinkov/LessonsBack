package com.example.lessonsback.Controller;

import com.example.lessonsback.Domain.model.Test;
import com.example.lessonsback.Service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;


    /**
     * Страница пользователей
     *
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String users(
            Model model
    ) {
        model.addAttribute("users", adminService.getAllUsers());
        return "/admin/users";
    }

    @GetMapping("/tests")
    public String tests(
            Model model
    ) {
        model.addAttribute("tests", adminService.getAllTests());
        return "admin/tests";
    }

    @GetMapping("/tests/edit/{id}")
    public String editProduct(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("test", adminService.getTestById(id));
        return "admin/edit-test";
    }

    /**
     * Редактирование товара
     */
    @PostMapping("/tests/edit")
    public String editProductPost(
            @ModelAttribute("test") Test test
    ) {
        adminService.saveTest(test);
        return "redirect:/admin/tests?success";
    }


}


//
//}
