package co.com.forohub.domain.mappers;

import co.com.forohub.domain.entities.Answer;
import co.com.forohub.domain.entities.Topic;
import co.com.forohub.domain.entities.User;
import co.com.forohub.domain.dto.answer.AnswerRequest;
import co.com.forohub.domain.dto.answer.AnswerResponse;
import co.com.forohub.domain.dto.answer.CreateAnswerRequest;
import org.springframework.data.domain.Slice;

import java.util.List;

public class AnswerMapper {
    public static AnswerResponse toAnswerResponse(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .message(answer.getMessage())
                .creationDate(answer.getCreationDate())
                .author(UserMapper.toUserResponse(answer.getAuthor()))
                .solution(answer.getSolution())
                .build();
    }

    public static Answer toAnswer(CreateAnswerRequest createAnswerRequest, Topic topic, User author) {
        return Answer.builder()
                .message(createAnswerRequest.getMessage())
                .topic(topic)
                .author(author)
                .solution(createAnswerRequest.getSolution())
                .build();
    }

    public static Answer toAnswer(AnswerRequest answerRequest, Topic topic, User author) {
        return Answer.builder()
                .id(answerRequest.getId())
                .message(answerRequest.getMessage())
                .topic(topic)
                .author(author)
                .solution(answerRequest.getSolution())
                .build();
    }

    public static Slice<AnswerResponse> toAnswerResponseSlice(Slice<Answer> answers) {
        return answers.map(AnswerMapper::toAnswerResponse);
    }

    public static List<AnswerResponse> toAnswerResponseList(List<Answer> answers) {
        return answers.stream().map(AnswerMapper::toAnswerResponse).toList();
    }
}
