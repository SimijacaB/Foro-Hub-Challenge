package com.app.challenge_foro.domain.reply;

import com.app.challenge_foro.domain.topic.Status;
import com.app.challenge_foro.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Builder
@Table(name = "replies")
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @PrePersist //Se ejecuta antes de que se guarde en la base de datos
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
