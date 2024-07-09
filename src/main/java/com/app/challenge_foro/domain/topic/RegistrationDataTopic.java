package com.app.challenge_foro.domain.topic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegistrationDataTopic(
        @NotNull
        @Size(min = 10, max = 200)
        @Pattern(regexp = "^[a-zA-Z]+$")
        String title,
        @NotNull
        @Size(min = 10, max = 1000)
        @Pattern(regexp = "^[a-zA-Z]+$")
        String message,
        @NotNull
        Course course

        //Long userId
        ) {
}
