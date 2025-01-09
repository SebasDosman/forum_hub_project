package co.com.forohub.service.implementation;

import co.com.forohub.domain.Answer;
import co.com.forohub.dto.answer.AnswerRequest;
import co.com.forohub.dto.answer.AnswerResponse;
import co.com.forohub.dto.answer.CreateAnswerRequest;
import co.com.forohub.exceptions.NotFoundException;
import co.com.forohub.mappers.AnswerMapper;
import co.com.forohub.repository.AnswerRepository;
import co.com.forohub.repository.TopicRepository;
import co.com.forohub.repository.UserRepository;
import co.com.forohub.service.IAnswerService;
import co.com.forohub.utils.validators.AnswerValidator;
import co.com.forohub.utils.validators.TopicValidator;
import co.com.forohub.utils.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AnswerService implements IAnswerService {
    private final AnswerRepository answerRepository;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Slice<AnswerResponse> findAll(Pageable pageable) {
        return AnswerMapper.toAnswerResponseSlice(answerRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public AnswerResponse findById(Long id) {
        if (!answerRepository.existsById(id)) throw new NotFoundException(String.format(AnswerValidator.ANSWER_NOT_FOUND, id));

        return AnswerMapper.toAnswerResponse(answerRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public AnswerResponse save(CreateAnswerRequest createAnswerRequest) {
        if (!topicRepository.existsById(createAnswerRequest.getTopicId())) throw new NotFoundException(String.format(TopicValidator.TOPIC_NOT_FOUND, createAnswerRequest.getTopicId()));
        if (!userRepository.existsById(createAnswerRequest.getAuthorId())) throw new NotFoundException(String.format(UserValidator.USER_NOT_FOUND, createAnswerRequest.getAuthorId()));

        Answer answer = AnswerMapper.toAnswer(createAnswerRequest, topicRepository.getReferenceById(createAnswerRequest.getTopicId()), userRepository.getReferenceById(createAnswerRequest.getAuthorId()));

        return AnswerMapper.toAnswerResponse(answerRepository.save(answer));
    }

    @Override
    @Transactional
    public AnswerResponse update(AnswerRequest answerRequest) {
        if (!answerRepository.existsById(answerRequest.getId())) throw new NotFoundException(String.format(AnswerValidator.ANSWER_NOT_FOUND, answerRequest.getId()));

        Answer answer = answerRepository.getReferenceById(answerRequest.getId());

        return AnswerMapper.toAnswerResponse(answerRepository.save(AnswerMapper.toAnswer(answerRequest, answer.getTopic(), answer.getAuthor())));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!answerRepository.existsById(id)) throw new NotFoundException(String.format(AnswerValidator.ANSWER_NOT_FOUND, id));

        answerRepository.deleteById(id);
    }
}
