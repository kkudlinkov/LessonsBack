package com.example.lessonsback.Domain.dto;

import com.example.lessonsback.Domain.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfoDTO {
    private boolean isAuth;
    private User user;
}