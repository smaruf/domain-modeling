package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author maruf
 * @since 10/19/17
 */
@Setter
@Getter
@Builder
public class User implements Serializable {
    private String userKey;
    private Set<Contribution> contributions;
}
