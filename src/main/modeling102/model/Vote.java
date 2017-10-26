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
    private TextContribution textContributions;

    @Builder
    public Vote(User user, TextContribution textContributions) {
        super(user);
        this.textContributions = textContributions;
    }
}
