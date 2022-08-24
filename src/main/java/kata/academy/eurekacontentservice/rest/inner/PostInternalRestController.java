package kata.academy.eurekacontentservice.rest.inner;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@Tag(name = "PostInternalRestController", description = "Контроллер для связи с postLike")
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/internal/v1/posts")
public class PostInternalRestController {

    @GetMapping("{postId}/exists")
    public ResponseEntity<Boolean> existsByPostId(@PathVariable @Positive Long postId){
        return ResponseEntity.ok(true);
    }
}
