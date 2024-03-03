package com.pawnprudence.backend.mappers;

import com.pawnprudence.backend.dtos.UserDto;
import com.pawnprudence.backend.dtos.UserResponseDto;
import com.pawnprudence.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserMapper {

    public User toNewUser(UserDto userDto) {
        if (userDto == null) {
            throw new NullPointerException("The user dto should not be null");
        }

        var user = new User();
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setDateCreated(new Date());
        user.setLastLogin(new Date());

        return user;
    }

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(
                user.getEmail(),
                user.getLastLogin()
        );
    }

}
