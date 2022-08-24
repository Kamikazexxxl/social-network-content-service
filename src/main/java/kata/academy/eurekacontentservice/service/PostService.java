package kata.academy.eurekacontentservice.service;

import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;

public interface PostService {

    Post addPost(PostPersistRequestDto dto);

    Post updatePost(PostUpdateRequestDto dto);

    void deletePost(Long postId);

    boolean existsById (Long postId);

    Post updatePost(Post post);
}
