package co.com.forohub.domain.mappers;

import co.com.forohub.domain.entities.Answer;
import co.com.forohub.domain.entities.Course;
import co.com.forohub.domain.entities.Topic;
import co.com.forohub.domain.entities.User;
import co.com.forohub.domain.dto.topic.CreateTopicRequest;
import co.com.forohub.domain.dto.topic.TopicRequest;
import co.com.forohub.domain.dto.topic.TopicResponse;
import org.springframework.data.domain.Slice;

import java.util.List;

public class TopicMapper {
    public static TopicResponse toTopicResponse(Topic topic) {
        return TopicResponse.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .message(topic.getMessage())
                .creationDate(topic.getCreationDate())
                .status(topic.getStatus())
                .author(UserMapper.toUserResponse(topic.getAuthor()))
                .course(CourseMapper.toCourseResponse(topic.getCourse()))
                .answers(AnswerMapper.toAnswerResponseList(topic.getAnswers()))
                .build();
    }

    public static Topic toTopic(CreateTopicRequest createTopicRequest, User author, Course course, List<Answer> answers) {
        return Topic.builder()
                .title(createTopicRequest.getTitle())
                .message(createTopicRequest.getMessage())
                .author(author)
                .course(course)
                .answers(answers)
                .build();
    }

    public static Topic toTopic(TopicRequest topicRequest, User author, Course course, List<Answer> answers) {
        return Topic.builder()
                .id(topicRequest.getId())
                .title(topicRequest.getTitle())
                .message(topicRequest.getMessage())
                .author(author)
                .course(course)
                .answers(answers)
                .build();
    }

    public static Slice<TopicResponse> toTopicResponseSlice(Slice<Topic> topics) {
        return topics.map(TopicMapper::toTopicResponse);
    }
}
