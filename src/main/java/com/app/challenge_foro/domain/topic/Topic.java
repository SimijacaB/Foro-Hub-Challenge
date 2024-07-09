package com.app.challenge_foro.domain.topic;

import com.app.challenge_foro.domain.reply.Reply;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 200)
    private String title;
    @Column(nullable = false, length = 1000)
    private String message;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Course course;

    @OneToMany(mappedBy = "topic")
    private List<Reply> replies;

    @PrePersist //Se ejecuta antes de que se guarde en la base de datos
    protected void onCreate() {
        if (status == null) {
            status = Status.OPEN;
        }
        this.createdAt = LocalDateTime.now();
    }
}
