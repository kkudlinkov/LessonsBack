package com.example.lessonsback.Service;

import com.example.lessonsback.Repository.UserRepository;
import com.example.lessonsback.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        return user.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }
}
