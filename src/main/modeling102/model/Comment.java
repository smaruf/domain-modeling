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
public class Comment extends TextContribution {
    private Idea idea;
    private Set<Comment> replies;

    @Builder
    public Comment(User user, String text, Set<Vote> votes, Idea idea, Set<Comment> replies) {
        super(user, votes, text);
        this.idea = idea;
        this.replies = replies;
    }
}
