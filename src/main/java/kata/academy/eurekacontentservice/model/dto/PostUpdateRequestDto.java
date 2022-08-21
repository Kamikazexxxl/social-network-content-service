package kata.academy.eurekacontentservice.model.dto;

import kata.academy.eurekacontentservice.model.entity.PostTag;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public record PostUpdateRequestDto(@NotBlank String title,
                            @NotBlank String text,
                            Set<PostTag> tags) {
}
