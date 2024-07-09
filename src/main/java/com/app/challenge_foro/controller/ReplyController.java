package com.app.challenge_foro.controller;

import com.app.challenge_foro.domain.reply.RegistrationDataReply;
import com.app.challenge_foro.domain.reply.ReplyDTO;
import com.app.challenge_foro.domain.reply.UpdateDataReply;
import com.app.challenge_foro.domain.service.IReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final IReplyService replyService;

    // Implementar los métodos del controlador
    @PostMapping("/save")
    public ResponseEntity<ReplyDTO> saveReply(@RequestBody RegistrationDataReply registrationDataReply) {
        return ResponseEntity.ok(replyService.createReply(registrationDataReply));
    }

    @PutMapping("/update")
    public ResponseEntity<ReplyDTO> updateReply(@RequestBody UpdateDataReply updateDataReply) {
        return ResponseEntity.ok(replyService.updateReply(updateDataReply));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        replyService.deleteReply(id);
        return ResponseEntity.noContent().build();
    }

}
