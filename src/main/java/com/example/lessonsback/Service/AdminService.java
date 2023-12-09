package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.model.Test;
import com.example.lessonsback.Domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserService userService;
    private final TestService testService;
//    private final UserMapper userMapper;

    /**
     * Получение всех пользователей
     */
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Получение пользователя по id
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userService.getById(id);
    }


    /**
     * Получение всех Фильмов
     *
     * @return
     */
    public List<Test> getAllTests() {
        return testService.getAllTests();
    }


    /**
     * Получение теста по id
     *
     * @param id
     * @return
     */
    public Test getTestById(int id) {
        return testService.getById(id);
    }

    /**
     * Сохранение теста
     *
     * @param test
     */
    @Transactional
    public void saveTest(Test test) {
        testService.save(test);
    }
}
