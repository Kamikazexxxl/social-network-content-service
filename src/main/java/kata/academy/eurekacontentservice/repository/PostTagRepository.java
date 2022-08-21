package kata.academy.eurekacontentservice.repository;

import kata.academy.eurekacontentservice.model.entity.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
}
