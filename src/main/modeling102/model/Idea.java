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
    private String title;
    private Set<Comment> comments;

    @Builder
    public Idea(User user, Set<Vote> votes, Set<Comment> comments, String text, String key, String title) {
        super(user, votes, text, key);
        this.comments = comments;
        this.title = title;
    }
}
