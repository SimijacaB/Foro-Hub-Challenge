package com.app.challenge_foro.domain.service;

import com.app.challenge_foro.domain.reply.Reply;
import com.app.challenge_foro.domain.topic.Topic;
import com.app.challenge_foro.domain.reply.RegistrationDataReply;
import com.app.challenge_foro.domain.reply.ReplyDTO;
import com.app.challenge_foro.domain.reply.UpdateDataReply;
import com.app.challenge_foro.domain.reply.IReplyRepository;
import com.app.challenge_foro.domain.topic.ITopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements IReplyService {

    private final IReplyRepository replyRepository;
    private final ITopicRepository topicRepository;

    @Override
    public ReplyDTO createReply(RegistrationDataReply registrationDataReply) {
        Long topicId = registrationDataReply.idTopic();
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new NoSuchElementException("No se encontró ningún tema con ID: " + topicId));

        var reply = new Reply();
        reply.setMessage(registrationDataReply.message());
        reply.setTopic(topic);

        replyRepository.save(reply);
        return convertDto(reply);
    }

    @Override
    public ReplyDTO updateReply(UpdateDataReply updateDataReply) {
        var reply = replyRepository.findById(updateDataReply.id())
                .orElseThrow(() -> new NoSuchElementException("No se encontró ninguna respuesta con ID: " + updateDataReply.id()));

        reply.setMessage(updateDataReply.message());
        replyRepository.save(reply);
        return convertDto(reply);
    }

    @Override
    public void deleteReply(Long id) {
        var reply = replyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró ninguna respuesta con ID: " + id));
        replyRepository.delete(reply);

    }

    private ReplyDTO convertDto(Reply reply) {
        return new ReplyDTO(reply.getId(), reply.getMessage(), reply.getCreatedAt());
    }
}
