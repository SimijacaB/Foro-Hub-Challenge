package com.app.challenge_foro.domain.topic;

import com.app.challenge_foro.domain.topic.Course;
import com.app.challenge_foro.domain.topic.Status;
import com.app.challenge_foro.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findByTitle(String title);

    List<Topic> findByCourse(Course course);

    List<Topic> findByStatus(Status status);




}
