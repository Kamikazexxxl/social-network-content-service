package kata.academy.eurekacontentservice.service.impl;

import kata.academy.eurekacontentservice.model.converter.PostMapper;
import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;
import kata.academy.eurekacontentservice.model.entity.PostTag;
import kata.academy.eurekacontentservice.repository.PostRepository;
import kata.academy.eurekacontentservice.repository.PostTagRepository;
import kata.academy.eurekacontentservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostTagRepository postTagRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostTagRepository postTagRepository) {
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
    }

    @Override
    public List<Post> getAllPosts () {
       return postRepository.findAll();
    }

    @Transactional
    @Override
    public Post addPost(PostPersistRequestDto dto, Long userId) {
        Post post = PostMapper.mapToEntity(dto, userId);
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public Post updatePost(PostUpdateRequestDto dto, Long postId, Long userId) {

        Post post = PostMapper.mapToEntity(dto, userId);
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public void deletePost(Long postId, Long userId){

        // TODO: добавить проверку на корректного юзера?:

//        if (userId == loggedInUserId) {
//            post.setUserId(userId);
//        } else {
//            throw new IllegalArgumentException("post with this id for this user is not found");
//        }

        if (existsById(postId)) {
            postRepository.deleteById(postId);
        }
    }

    @Override
    public boolean existsById (Long postId) {
        return postRepository.existsById(postId);
    }

    @Override
    public List<Post> getPostByTag (String tag) {
        return postRepository.getPostByTag(tag);
    }

    @Override
    public List<PostTag> getAllTags () {
        return postTagRepository.findAll();
    }

}
