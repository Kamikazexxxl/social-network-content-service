package kata.academy.eurekacontentservice.model.converter;

import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;

public class PostMapper {

    public static Post mapToEntity (PostPersistRequestDto dto, Long userId) {
        Post post = new Post();
        post.setText(dto.text());
        post.setTitle(dto.title());
        post.setTags(dto.tags());

        // TODO: добавить проверку на корректного юзера?:

//        if (userId == loggedInUserId) {
//            post.setUserId(userId);
//        } else {
//            throw new IllegalArgumentException("incorrect user id");
//        }
        return post;
    }

    public static Post mapToEntity (PostUpdateRequestDto dto, Long userId) {
        Post post = new Post();
        post.setText(dto.text());
        post.setTitle(dto.title());
        post.setTags(dto.tags());

        // TODO: добавить проверку на корректного юзера?:

//        if (userId == loggedInUserId) {
//            post.setUserId(userId);
//        } else {
//            throw new IllegalArgumentException("incorrect user id");
//        }
        return post;
    }
}
