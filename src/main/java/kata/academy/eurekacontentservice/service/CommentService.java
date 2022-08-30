package kata.academy.eurekacontentservice.service;

import kata.academy.eurekacontentservice.model.entity.Comment;

public interface CommentService {

    Comment addComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteById(Long commentId);

    boolean existsByCommentIdAndPostId(Long commentId, Long postId);
}
