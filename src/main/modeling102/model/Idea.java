package main.modeling102.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author maruf
 * @since 10/19/17
 */
@Setter
@Getter
public class Idea extends TextContribution {
    private Set<Comment> comments;

    @Builder
    public Idea(User user, Set<Vote> votes, Set<Comment> comments) {
        super(user, votes);
        this.comments = comments;
    }
}
