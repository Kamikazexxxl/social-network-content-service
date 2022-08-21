package kata.academy.eurekacontentservice.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long tagId;
    String tag;

    @JsonIgnore
    @ManyToMany (mappedBy = "tags")
    private Set<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTag postTag = (PostTag) o;
        return Objects.equals(tagId, postTag.tagId) && Objects.equals(tag, postTag.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tag);
    }
}
