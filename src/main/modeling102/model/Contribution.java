package model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author maruf
 * @since 10/19/17
 */
@Getter
@Setter
public abstract class Contribution implements Serializable {
    private User user;

    public Contribution(User user) {
        this.user = user;
    }
}
