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
@Builder
public class User {
    private Set<Contribution> contributions;
}
