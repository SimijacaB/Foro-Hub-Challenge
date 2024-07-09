package com.app.challenge_foro.domain.topic;

import java.time.LocalDateTime;

public record TopicDTO(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        Status status,
         Course course) {
}
