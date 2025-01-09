package co.com.forohub.service;

import co.com.forohub.dto.answer.AnswerRequest;
import co.com.forohub.dto.answer.AnswerResponse;
import co.com.forohub.dto.answer.CreateAnswerRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IAnswerService {
    Slice<AnswerResponse> findAll(Pageable pageable);
    AnswerResponse findById(Long id);
    AnswerResponse save(CreateAnswerRequest createAnswerRequest);
    AnswerResponse update(AnswerRequest answerRequest);
    void delete(Long id);
}
