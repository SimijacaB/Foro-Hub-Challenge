package com.app.challenge_foro.domain.reply;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegistrationDataReply(
        @NotNull
        @Size(min = 10, max = 200)
        @Pattern(regexp = "^[a-zA-Z]+$")
        String message,
        @NotNull
        Long idTopic
       ) {
}
