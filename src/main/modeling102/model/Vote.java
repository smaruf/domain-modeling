package main.modeling102.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author maruf
 * @since 10/19/17
 */
@Setter
@Getter
public class Vote extends Contribution {
    private TextContribution textContribution;

    @Builder
    public Vote(User user, TextContribution textContribution) {
        super(user);
        this.textContribution = textContribution;
    }
}
