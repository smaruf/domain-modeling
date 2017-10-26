package main.modeling102.model;

import java.io.Serializable;

/**
 * @author maruf
 * @since 10/19/17
 */
public abstract class Contribution implements Serializable {
    private User user;

    public Contribution(User user) {
        this.user = user;
    }
}
