package com.app.challenge_foro.domain.topic;

import com.app.challenge_foro.domain.reply.ReplyDTO;

import java.time.LocalDateTime;
import java.util.List;

public record ListDataTopic(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        List<ReplyDTO> replies,
        Status status,
        Course course
) {
}
