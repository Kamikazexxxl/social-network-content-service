package kata.academy.eurekacontentservice.repository;


import kata.academy.eurekacontentservice.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p join p.tags t where t.tag = :tag")
    List<Post> getPostByTag (@Param("tag")String tag);
}