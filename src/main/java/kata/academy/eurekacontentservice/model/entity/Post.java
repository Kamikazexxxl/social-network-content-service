package kata.academy.eurekacontentservice.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    String title;
    String text;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    Set<PostTag> tags = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(userId, post.userId) && Objects.equals(title, post.title) && Objects.equals(text, post.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, text);
    }
}
