package co.com.forohub.mappers;

import co.com.forohub.domain.Answer;
import co.com.forohub.domain.Topic;
import co.com.forohub.domain.User;
import co.com.forohub.dto.answer.AnswerRequest;
import co.com.forohub.dto.answer.AnswerResponse;
import co.com.forohub.dto.answer.CreateAnswerRequest;
import org.springframework.data.domain.Slice;

import java.util.List;

public class AnswerMapper {
    public static AnswerResponse toAnswerResponse(Answer answer) {
        return AnswerResponse.builder()
                .message(answer.getMessage())
                .topic(TopicMapper.toTopicResponse(answer.getTopic()))
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
