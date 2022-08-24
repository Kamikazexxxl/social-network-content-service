package kata.academy.eurekacontentservice.service.impl;

import kata.academy.eurekacontentservice.model.converter.PostMapper;
import kata.academy.eurekacontentservice.model.dto.PostPersistRequestDto;
import kata.academy.eurekacontentservice.model.dto.PostUpdateRequestDto;
import kata.academy.eurekacontentservice.model.entity.Post;
import kata.academy.eurekacontentservice.repository.PostRepository;
import kata.academy.eurekacontentservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post addPost(PostPersistRequestDto dto) {
        Post post = PostMapper.toEntity(dto);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(PostUpdateRequestDto dto) {
        Post post = PostMapper.toEntity(dto);
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId){
        if (postRepository.existsById(postId)) {
            postRepository.deleteById(postId);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById (Long postId) {
        return postRepository.existsById(postId);
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }
}
