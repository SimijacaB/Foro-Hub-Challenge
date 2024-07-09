package com.app.challenge_foro.domain.service;

import com.app.challenge_foro.domain.reply.RegistrationDataReply;
import com.app.challenge_foro.domain.reply.ReplyDTO;
import com.app.challenge_foro.domain.reply.UpdateDataReply;

public interface IReplyService {
    ReplyDTO createReply(RegistrationDataReply registrationDataReply);

    ReplyDTO updateReply(UpdateDataReply updateDataReply);

    void deleteReply(Long id);
}
