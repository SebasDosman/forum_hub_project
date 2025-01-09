package co.com.forohub.service;

import co.com.forohub.dto.topic.CreateTopicRequest;
import co.com.forohub.dto.topic.TopicRequest;
import co.com.forohub.dto.topic.TopicResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ITopicService {
    Slice<TopicResponse> findAll(Pageable pageable);
    Slice<TopicResponse> findAllByStatusTrue(Pageable pageable);
    TopicResponse findById(Long id);
    TopicResponse save(CreateTopicRequest createTopicRequest);
    TopicResponse update(TopicRequest topicRequest);
    TopicResponse updateStatus(Long id);
    void delete(Long id);
}
