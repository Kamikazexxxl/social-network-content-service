package kata.academy.eurekacontentservice.service;

import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;
import kata.academy.eurekacontentservice.model.entity.PostTag;

import java.util.List;

public interface PostService {

    Post addPost(PostPersistRequestDto dto, Long userId);

    Post updatePost(PostUpdateRequestDto dto, Long postId, Long userId);

    void deletePost(Long postId, Long userId);

    boolean existsById (Long postId);

    List<Post> getAllPosts ();

    List<Post> getPostByTag (String tag);

    List<PostTag> getAllTags ();
}
