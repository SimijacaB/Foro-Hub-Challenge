package com.app.challenge_foro.domain.reply;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateDataReply(
        @NotNull
        Long id,
        @NotNull
        @Pattern(regexp = "^[a-zA-Z]+$")
        String message
) {
}
