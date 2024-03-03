package com.pawnprudence.backend.services;

import com.pawnprudence.backend.dtos.UserDto;
import com.pawnprudence.backend.dtos.UserResponseDto;
import com.pawnprudence.backend.mappers.UserMapper;
import com.pawnprudence.backend.models.User;
import com.pawnprudence.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto saveUser(
            UserDto userDto
    ) {
        var user = userMapper.toNewUser(userDto);
        var savedUser = userRepository.save(user);
        return userMapper.toUserResponseDto(savedUser);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElse(null);
    }

}
