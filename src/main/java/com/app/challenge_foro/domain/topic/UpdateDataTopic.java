package com.app.challenge_foro.domain.topic;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateDataTopic(
        @NotNull
        Long id,
        @NotNull
        @Min(3)
        @Pattern(regexp = "^[a-zA-Z]+$")
        String title,
        @NotNull
        @Min(3)
        @Pattern(regexp = "^[a-zA-Z]+$")
        String message,
        @NotNull
        Course course
) {
}
