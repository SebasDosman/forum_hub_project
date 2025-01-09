package co.com.forohub.repository;

import co.com.forohub.domain.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Slice<Topic> findAllByStatusTrue(Pageable pageable);
}
