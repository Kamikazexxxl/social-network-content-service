package kata.academy.eurekacontentservice.rest.outer;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kata.academy.eurekacontentservice.api.Response;
import kata.academy.eurekacontentservice.model.converter.CommentMapper;
import kata.academy.eurekacontentservice.model.converter.PostMapper;
import kata.academy.eurekacontentservice.model.dto.CommentPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.CommentUpdateRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Comment;
import kata.academy.eurekacontentservice.model.entity.Post;
import kata.academy.eurekacontentservice.service.CommentService;
import kata.academy.eurekacontentservice.util.ApiValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.ws.rs.Path;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1/posts")
public class CommentRestController {
    CommentService commentService;

    @Operation(summary = "Создание нового комментария")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Новый комментарий успешно создан")
    })
    @PostMapping("{postId}/comments")
    public Response<Comment> addComment(@RequestBody CommentPersistRequestDto dto,
                                        @PathVariable @Positive Long postId,
                                        @RequestParam @Positive Long userId
    ) {
        Comment comment = CommentMapper.toEntity(dto);
        Post post = new Post();
        post.setId(postId);
        comment.setUserId(userId);
        comment.setPost(post);
        return Response.ok(commentService.addComment(comment));
    }

    @Operation(summary = "Обновление существующего комментария")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Существующий комментарий успешно обновлен"),
            @ApiResponse(responseCode = "400", description = "Комментарий не найден")
    })
    @PutMapping("/{postId}/comments/{commentId}")
    public Response<Comment> updateComment(@RequestBody CommentUpdateRequestDto dto,
                                           @PathVariable @Positive Long postId,
                                           @PathVariable @Positive Long commentId,
                                           @RequestParam @Positive Long userId) {
        ApiValidationUtil.requireTrue(commentService.existsByCommentIdAndPostId(commentId, postId), String.format
                ("Пост с postId %d и commentId %d нет в базе данных", postId, commentId));
        Comment comment = CommentMapper.toEntity(dto);
        Post post = new Post();
        post.setId(postId);
        comment.setId(commentId);
        comment.setUserId(userId);
        comment.setPost(post);
        return Response.ok(commentService.updateComment(comment));
    }

    @DeleteMapping("//{postId}/comments/{commentId}")
    public Response<Void> deleteComment(@PathVariable @Positive Long postId,
                                        @PathVariable @Positive Long commentId,
                                        @RequestParam @Positive Long userId) {
        ApiValidationUtil.requireTrue(commentService.existsByCommentIdAndPostId(commentId, postId), String.format
                ("Пост с postId %d и userId %d нет в базе данных", postId, userId));
        commentService.deleteById(commentId);
        return Response.ok();
    }
}
