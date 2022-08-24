package kata.academy.eurekacontentservice.model.converter;


import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;

public final class PostMapper {

    private PostMapper() {
    }

    public static Post toEntity(PostPersistRequestDto dto) {
        Post post = new Post();
        post.setText(dto.text());
        post.setTitle(dto.title());
        post.setTags(dto.tags());
        return post;
    }

    public static Post toEntity(PostUpdateRequestDto dto) {
        Post post = new Post();
        post.setText(dto.text());
        post.setTitle(dto.title());
        post.setTags(dto.tags());
        return post;
    }

    public static Post toEntity(PostUpdateRequestDto dto, Long postId, Long userId) {
        Post post = new Post();
        post.setText(dto.text());
        post.setTitle(dto.title());
        post.setTags(dto.tags());
        post.setId(postId);
        post.setUserId(userId);
        return post;
    }
}
