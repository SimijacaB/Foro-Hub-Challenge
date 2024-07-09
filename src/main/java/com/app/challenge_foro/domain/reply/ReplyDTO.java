package com.app.challenge_foro.domain.reply;

import java.time.LocalDateTime;

public record ReplyDTO(Long id, String message, LocalDateTime createdAt) {

}
