package com.pawnprudence.backend.dtos;

import java.util.Date;

public record UserResponseDto(
        String email,
        Date lastLogin
) {
}
