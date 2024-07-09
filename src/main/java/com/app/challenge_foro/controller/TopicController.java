package com.app.challenge_foro.controller;

import com.app.challenge_foro.domain.topic.Course;
import com.app.challenge_foro.domain.topic.Status;
import com.app.challenge_foro.domain.topic.ListDataTopic;
import com.app.challenge_foro.domain.topic.RegistrationDataTopic;
import com.app.challenge_foro.domain.topic.TopicDTO;
import com.app.challenge_foro.domain.topic.UpdateDataTopic;
import com.app.challenge_foro.domain.service.ITopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class TopicController {

    private final ITopicService topicService;

    // Implementar los métodos del controlador
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TopicDTO createTopic(@RequestBody RegistrationDataTopic registrationDataTopic) {
        return topicService.createTopic(registrationDataTopic);
    }

    @PutMapping("/update")
    public TopicDTO updateTopic(@RequestBody UpdateDataTopic updateDataTopic) {
        return topicService.updateTopic(updateDataTopic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id,  @RequestBody String status) {
        topicService.updateStatus(id, status);
    }

    @GetMapping("/all")
    public List<TopicDTO> getAllTopics() {
        return topicService.getTopics();
    }

    @GetMapping("/{id}")
    public ListDataTopic getTopicById(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }


    @GetMapping("/course/{course}")
    public List<TopicDTO> getTopicsByCourse(@PathVariable Course course) {
        return topicService.getTopicsByCourse(course);
    }

    @GetMapping("/status/{status}")
    public List<TopicDTO> getTopicsByStatus(@PathVariable Status status) {
        return topicService.getTopicsByStatus(status);}

}
