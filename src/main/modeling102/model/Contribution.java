package main.modeling102.model;

/**
 * @author maruf
 * @since 10/19/17
 */
public abstract class Contribution {
    private User user;

    public Contribution(User user) {
        this.user = user;
    }
}
