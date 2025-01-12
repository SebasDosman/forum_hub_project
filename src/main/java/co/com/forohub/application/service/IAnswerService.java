package co.com.forohub.application.service;

import co.com.forohub.domain.dto.answer.AnswerRequest;
import co.com.forohub.domain.dto.answer.AnswerResponse;
import co.com.forohub.domain.dto.answer.CreateAnswerRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IAnswerService {
    Slice<AnswerResponse> findAll(Pageable pageable);
    AnswerResponse findById(Long id);
    AnswerResponse save(CreateAnswerRequest createAnswerRequest);
    AnswerResponse update(AnswerRequest answerRequest);
    void delete(Long id);
}
