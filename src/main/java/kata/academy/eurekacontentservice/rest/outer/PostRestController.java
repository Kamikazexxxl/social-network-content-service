package kata.academy.eurekacontentservice.rest.outer;


import kata.academy.eurekacontentservice.api.Response;
import kata.academy.eurekacontentservice.model.converter.PostMapper;
import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;
import kata.academy.eurekacontentservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostRestController {

    private PostService postService;

    @PostMapping
    Response<Post> addPost(@Valid @RequestBody PostPersistRequestDto dto, @RequestParam @Positive Long userId) {
        return Response.ok(postService.addPost(dto));
    }


    @PutMapping("/{postId}")
    public Response<Post> updatePost(@Valid @RequestBody PostUpdateRequestDto dto,
                                     @PathVariable @Positive Long postId,
                                     @RequestParam @Positive Long userId) {
        if (existsByPostIdAndUserId(postId, userId)) {
            Post post = PostMapper.toEntity(dto, postId, userId);
            return Response.ok(postService.updatePost(post));
        }
        return Response.error("post does not exist for current user");
    }

    @Positive
    @DeleteMapping("/{postId}")
    public Response<Void> deletePost(@PathVariable Long postId, @RequestParam @Positive Long userId){
        if (existsByPostIdAndUserId(postId, userId)) {
            postService.deletePost(postId);
            return Response.ok();
        }
        return Response.error("post does not exist for current user");
    }


    public boolean existsByPostIdAndUserId (Long postId, Long userId) {
        //TODO: имплементация проверки поста и юзера (валидация только в контролере, в PostService не добавляем?):
        /*
         * if (exists(postId) && (userId == findPost(postId).userId)) {
         *      return true;
         *  }
         *  return false;
         */
        return true;
    }
}
