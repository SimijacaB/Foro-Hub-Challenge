package com.app.challenge_foro.domain.service;

import com.app.challenge_foro.domain.reply.ReplyDTO;
import com.app.challenge_foro.domain.topic.*;
import com.app.challenge_foro.entities.topic.*;
import com.app.challenge_foro.domain.topic.ITopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements ITopicService {

    private final ITopicRepository topicRepository;


    @Override
    public TopicDTO createTopic(RegistrationDataTopic registrationDataTopic) {
        var topicExist = topicRepository.findByTitle(registrationDataTopic.title());

        if (topicExist.isPresent()) {
            throw new RuntimeException("Topic already exists");
        }

        Topic topic = convertToEntity(registrationDataTopic);
        if (topic.getStatus() == null) {
            topic.setStatus(Status.OPEN);
        }
        Topic savedTopic = topicRepository.save(topic);
        return convertToDto(savedTopic);
    }

    @Override
    public void deleteTopic(Long id) {
        var topic = topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
        topicRepository.delete(topic);
    }

    @Override
    public TopicDTO updateTopic(UpdateDataTopic updateDataTopic) {
        var topic = topicRepository.findById(updateDataTopic.id()).orElseThrow(() -> new RuntimeException("Topic not found"));
        topic.setTitle(updateDataTopic.title());
        topic.setMessage(updateDataTopic.message());
        topic.setCourse(updateDataTopic.course());
        var savedTopic = topicRepository.save(topic);
        return convertToDto(savedTopic);

    }

    @Override
    public void updateStatus(Long id, String status) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró ningún tema con ID: " + id));

        if (status.equals("OPEN")) {
            topic.setStatus(Status.OPEN);
            topicRepository.save(topic);
        } else if (status.equals("CLOSED")) {
            topic.setStatus(Status.CLOSED);
            topicRepository.save(topic);

        }
    }

    @Override
    public ListDataTopic getTopicById(Long id) {
        var topic = topicRepository.findById(id).orElseThrow();
        return convertToListDto(topic);
    }


    @Override
    public List<TopicDTO> getTopics() {
        var topics = topicRepository.findAll();
        return topics.stream().map(this::convertToDto).toList();
    }

    @Override
    public List<TopicDTO> getTopicsByCourse(Course course) {
        var topics = topicRepository.findByCourse(course);
        return topics.stream().map(this::convertToDto).toList();
    }

    @Override
    public List<TopicDTO> getTopicsByStatus(Status status) {
        var topics = topicRepository.findByStatus(status);
        return topics.stream().map(this::convertToDto).toList();
    }

    private TopicDTO convertToDto(Topic savedTopic) {
        return new TopicDTO(
                savedTopic.getId(),
                savedTopic.getTitle(),
                savedTopic.getMessage(),
                savedTopic.getCreatedAt(),
                savedTopic.getStatus(),
                savedTopic.getCourse()
        );
    }

    private Topic convertToEntity(RegistrationDataTopic registrationDataTopic) {
        return Topic.builder()
                .title(registrationDataTopic.title())
                .message(registrationDataTopic.message())
                .course(registrationDataTopic.course())
                .build();
    }

    private ListDataTopic convertToListDto(Topic topic) {
        return new ListDataTopic(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.getReplies().stream().map(reply -> new ReplyDTO(reply.getId(), reply.getMessage(), reply.getCreatedAt())).toList(),
                topic.getStatus(),
                topic.getCourse()
        );
    }



}
