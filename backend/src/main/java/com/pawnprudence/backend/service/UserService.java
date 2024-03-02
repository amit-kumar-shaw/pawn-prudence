package com.pawnprudence.backend.service;

import com.pawnprudence.backend.dto.UserDto;
import com.pawnprudence.backend.dto.UserResponseDto;
import com.pawnprudence.backend.mapper.UserMapper;
import com.pawnprudence.backend.model.User;
import com.pawnprudence.backend.repository.UserRepository;
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
        return userRepository.findByEmail(email);
    }

}
