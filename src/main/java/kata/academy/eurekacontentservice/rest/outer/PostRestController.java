package kata.academy.eurekacontentservice.rest.outer;

import kata.academy.eurekacontentservice.api.Response;
import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;
import kata.academy.eurekacontentservice.model.entity.PostTag;
import kata.academy.eurekacontentservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
public class PostRestController {

    private PostService postService;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts () {
        return postService.getAllPosts();
    }

    @PostMapping("/addPost")
    Response<Post> addPost(PostPersistRequestDto dto, @RequestParam @Positive Long userId) {
        return Response.ok(postService.addPost(dto,userId));
    }

    @PutMapping("/update/{postId}")
    Response<Post> updatePost(@RequestBody PostUpdateRequestDto dto, @PathVariable @Positive Long postId, @RequestParam @Positive Long userId) {
        return Response.ok(postService.updatePost(dto, postId, userId));
    }

    @DeleteMapping("/delete/{postId}")
    Response<Void> deletePost(@PathVariable Long postId, @RequestParam @Positive Long userId){
        postService.deletePost(postId, userId);
        return Response.ok();
    }

    @GetMapping("/tags")
    public List<PostTag> getAllTags () {
        return postService.getAllTags();
    }

    @GetMapping("/{tag}")
    public Response<List<Post>> getPostByTag (@PathVariable String tag) {
        return Response.ok(postService.getPostByTag(tag));
    }
}
