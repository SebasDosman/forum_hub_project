package co.com.forohub.application.service.implementation;

import co.com.forohub.domain.entities.Topic;
import co.com.forohub.domain.dto.topic.CreateTopicRequest;
import co.com.forohub.domain.dto.topic.TopicRequest;
import co.com.forohub.domain.dto.topic.TopicResponse;
import co.com.forohub.domain.exceptions.NotFoundException;
import co.com.forohub.domain.mappers.TopicMapper;
import co.com.forohub.application.repository.AnswerRepository;
import co.com.forohub.application.repository.CourseRepository;
import co.com.forohub.application.repository.TopicRepository;
import co.com.forohub.application.repository.UserRepository;
import co.com.forohub.application.service.ITopicService;
import co.com.forohub.domain.validators.AnswerValidator;
import co.com.forohub.domain.validators.CourseValidator;
import co.com.forohub.domain.validators.TopicValidator;
import co.com.forohub.domain.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class TopicService implements ITopicService {
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final AnswerRepository answerRepository;

    @Override
    @Transactional(readOnly = true)
    public Slice<TopicResponse> findAll(Pageable pageable) {
        return TopicMapper.toTopicResponseSlice(topicRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public Slice<TopicResponse> findAllByStatusTrue(Pageable pageable) {
        return TopicMapper.toTopicResponseSlice(topicRepository.findAllByStatusTrue(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public TopicResponse findById(Long id) {
        if (!topicRepository.existsById(id)) throw new RuntimeException(String.format(TopicValidator.TOPIC_NOT_FOUND, id));

        return TopicMapper.toTopicResponse(topicRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public TopicResponse save(CreateTopicRequest createTopicRequest) {
        validateCreateTopicRequest(createTopicRequest);

        Topic topic = TopicMapper.toTopic(createTopicRequest, userRepository.getReferenceById(createTopicRequest.getAuthorId()), courseRepository.getReferenceById(createTopicRequest.getCourseId()), answerRepository.findAllById(Arrays.stream(createTopicRequest.getAnswerIds()).toList()));

        return TopicMapper.toTopicResponse(topicRepository.save(topic));
    }

    @Override
    @Transactional
    public TopicResponse update(TopicRequest topicRequest) {
        if (!topicRepository.existsById(topicRequest.getId())) throw new NotFoundException(String.format(TopicValidator.TOPIC_NOT_FOUND, topicRequest.getId()));

        Topic topic = topicRepository.getReferenceById(topicRequest.getId());

        return TopicMapper.toTopicResponse(topicRepository.save(TopicMapper.toTopic(topicRequest, topic.getAuthor(), topic.getCourse(), topic.getAnswers())));
    }

    @Override
    @Transactional
    public TopicResponse updateStatus(Long id) {
        if (!topicRepository.existsById(id)) throw new NotFoundException(String.format(TopicValidator.TOPIC_NOT_FOUND, id));

        Topic topic = topicRepository.getReferenceById(id);
        topic.setStatus(!topic.getStatus());

        return TopicMapper.toTopicResponse(topicRepository.save(topic));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!topicRepository.existsById(id)) throw new NotFoundException(String.format(TopicValidator.TOPIC_NOT_FOUND, id));

        topicRepository.deleteById(id);
    }

    private void validateCreateTopicRequest(CreateTopicRequest createTopicRequest) {
        if (!userRepository.existsById(createTopicRequest.getAuthorId())) throw new NotFoundException(String.format(UserValidator.USER_NOT_FOUND, createTopicRequest.getAuthorId()));
        if (!courseRepository.existsById(createTopicRequest.getCourseId())) throw new NotFoundException(String.format(CourseValidator.COURSE_NOT_FOUND, createTopicRequest.getCourseId()));
        if (createTopicRequest.getAnswerIds() != null) {
            for (Long answerId: createTopicRequest.getAnswerIds()) {
                if (!answerRepository.existsById(answerId)) throw new NotFoundException(String.format(AnswerValidator.ANSWER_NOT_FOUND, answerId));
            }
        }
    }
}
