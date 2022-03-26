package ripoff.facebook.relation.command;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/relation")
@AllArgsConstructor
public class RelationCommandController {

    RelationCommandService service;

    @PostMapping("follow")
    public void followUser(@RequestBody FollowRequest request){
        service.follow(request.getFollowerId(), request.getTargetId());
    }

    @DeleteMapping("follow")
    public void unfollowUser(@RequestBody FollowRequest request) {
        service.unfollow(request.getFollowerId(), request.getTargetId());
    }

    @PostMapping("friend")
    @Transactional
    public void makeFriendship(@RequestBody FriendshipRequest request) {
        service.makeFriendship(request.getFriend1(), request.getFriend2());
    }

    @DeleteMapping("friend")
    public void unfriend(@RequestBody FriendshipRequest request) {
        service.unfriend(request.getFriend1(), request.getFriend2());
    }
}
