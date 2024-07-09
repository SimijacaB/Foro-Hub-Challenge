package com.app.challenge_foro.domain.reply;

import com.app.challenge_foro.domain.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IReplyRepository extends JpaRepository<Reply, Long> {

    Optional<Reply> findById(Long id);
}
