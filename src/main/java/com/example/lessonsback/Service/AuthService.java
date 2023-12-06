package com.example.lessonsback.Service;

import com.example.lessonsback.Domain.dto.UserInfoDTO;
import com.example.lessonsback.Domain.model.User;
import com.example.lessonsback.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    /**
     * Получение авторизованного пользователя
     * @return
     */
    public Optional<User> getAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }
        return Optional.of(((SecurityUser) authentication.getPrincipal()).getUser());
    }

    public UserInfoDTO getUserInfo() {
        // Получаем авторизованного пользователя
        var user = getAuthUser().orElse(null);

        // Если пользователь не авторизован, то возвращаем пустой объект
        if (user == null) {
            return new UserInfoDTO(false, null);
        } else {
            // Если пользователь авторизован, то возвращаем информацию о нём
            return new UserInfoDTO(true, user);
        }
    }
}