package com.example.lessonsback.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.lessonsback.Domain.model.User;
import com.example.lessonsback.Repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//  private final UserMapper userMapper;

    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * Поиск пользователя по email
     *
     * @param username
     * @return
     */
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Получение конкретного юзера
     *
     * @return
     */
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * Получение конкретного юзера
     *
     * @return
     */
    public User getById(int id) {
        return findById(id).orElseThrow();
    }
}
