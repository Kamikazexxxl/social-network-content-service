package kata.academy.eurekacontentservice.repository;

import kata.academy.eurekacontentservice.model.entity.Comment;
import kata.academy.eurekacontentservice.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    boolean existsByCommentIdAndPostId(Long commentId, Long PostId);
}
