package ripoff.facebook.post;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository repository;

    public void createPost(PostCreationRequest request){
        Post post = Post.builder()
                .userId(request.getUserId())
                .content(request.getContent())
                .creationDate(LocalDateTime.now())
                .attachmentPath(null)
                .build();

        repository.save(post);
    }

    public List<Post> getAllPostsByUser(Long userId) {
        return repository.findAllByUserId(userId);
    }
}
