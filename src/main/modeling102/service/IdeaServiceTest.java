package main.modeling102.service;

import main.modeling102.model.Idea;
import main.modeling102.model.User;
import main.modeling102.service.impl.IdeaServiceSerializerImpl;
import org.junit.Test;

import java.util.Objects;


/**
 * @author maruf
 * @since 10/26/17
 */
public class IdeaServiceTest {
    private IdeaService ideaService = IdeaServiceSerializerImpl.getInstance();

    @Test
    public void testAddNewIdea() throws Exception {
        User user = User.builder().build();
        Idea idea = Idea.builder().user(user).build();
        idea = ideaService.addNewIdea(idea);
        assert Objects.nonNull(idea);
    }

}