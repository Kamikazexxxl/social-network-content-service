package kata.academy.eurekacontentservice.service.impl;

import kata.academy.eurekacontentservice.model.entity.Comment;
import kata.academy.eurekacontentservice.repository.CommentRepository;
import kata.academy.eurekacontentservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByCommentIdAndPostId(Long commentId, Long postId) {
        return commentRepository.existsByCommentIdAndPostId(commentId, postId);
    }
    private final CommentRepository commentRepository;
}
