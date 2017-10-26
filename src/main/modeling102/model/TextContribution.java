package main.modeling102.model;

import java.util.Set;

/**
 * @author maruf
 * @since 10/19/17
 */
public abstract class TextContribution extends Contribution {
    private Set<Vote> votes;

    public TextContribution(User user, Set<Vote> votes) {
        super(user);
        this.votes = votes;
    }
}
