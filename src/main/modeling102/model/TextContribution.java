package main.modeling102.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author maruf
 * @since 10/19/17
 */
@Setter
@Getter
public abstract class TextContribution extends Contribution {
    private String text;
    private String key;
    private Set<Vote> votes;

    public TextContribution(User user, Set<Vote> votes, String text, String key) {
        super(user);
        this.votes = votes;
        this.text = text;
        this.key = key;
    }
}
