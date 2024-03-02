package com.pawnprudence.backend.dto;

import java.util.Date;

public record UserResponseDto(
        String email,
        Date lastLogin
) {
}
