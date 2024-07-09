package com.app.challenge_foro.domain.service;

import com.app.challenge_foro.domain.topic.Course;
import com.app.challenge_foro.domain.topic.Status;
import com.app.challenge_foro.domain.topic.ListDataTopic;
import com.app.challenge_foro.domain.topic.RegistrationDataTopic;
import com.app.challenge_foro.domain.topic.TopicDTO;
import com.app.challenge_foro.domain.topic.UpdateDataTopic;

import java.util.List;

public interface ITopicService {

    TopicDTO createTopic(RegistrationDataTopic registrationDataTopic);
    void deleteTopic(Long id);
    TopicDTO updateTopic(UpdateDataTopic updateDataTopic);
    void updateStatus(Long id, String status);

    ListDataTopic getTopicById(Long id);
    List<TopicDTO> getTopics();

    List<TopicDTO> getTopicsByCourse(Course course);
List<TopicDTO> getTopicsByStatus(Status status);





}
