package main.modeling102.service;

import main.modeling102.model.Comment;
import main.modeling102.model.Idea;
import main.modeling102.model.User;
import main.modeling102.service.impl.IdeaSerializationImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author maruf
 * @since 10/29/17
 */
public class IdeaServiceTest {
    private IdeaService ideaService = IdeaSerializationImpl.getInstance();

    @Test
    public void saveIdea() throws Exception {
        User user = User.builder().userKey("first-user").build();
        Idea idea = Idea.builder().user(user).text("New Idea").title("First Idea").key("idea-1").build();
        idea = ideaService.saveIdea(idea);
        Assert.assertNotNull(idea);
        idea = Idea.builder().user(user).text("New Idea").title("Second Idea").key("idea-2").build();
        idea = ideaService.saveIdea(idea);
        Assert.assertNotNull(idea);
        idea = Idea.builder().user(user).text("New Idea").title("Third Idea").key("idea-3").build();
        idea = ideaService.saveIdea(idea);
        Assert.assertNotNull(idea);

    }

    @Test
    public void findIdeas() throws Exception {
        User user = User.builder().userKey("first-user").build();
        Idea idea = Idea.builder().user(user).text("New Idea").title("Forth Idea").key("idea-4").build();
        ideaService.saveIdea(idea);
        List<Idea> ideas = ideaService.findIdeas();
        Assert.assertNotNull(ideas);
        Assert.assertNotEquals(0, ideas.size());
    }

    @Test
    public void findIdeaByKey() throws Exception {
        User user = User.builder().userKey("first-user").build();
        Idea idea = Idea.builder().user(user).text("New Idea").title("Fifth Idea").key("idea-4").build();
        ideaService.saveIdea(idea);
        idea = ideaService.findIdeaByKey("idea-2");
        Assert.assertNotNull(idea);
    }

    @Test
    public void saveComment() throws Exception {
        Idea idea = ideaService.findIdeaByKey("idea-3");
        Assert.assertNotNull(idea);
        Comment comment = Comment.builder()
                .idea(idea)
                .user(User.builder().userKey("second-user").build())
                .text("Comment 11111")
                .build();
        comment = ideaService.saveComment(idea, comment);
        Assert.assertNotNull(comment);
        Assert.assertNotNull(comment.getKey());

    }

    @Test
    public void replyComment() throws Exception {
        Idea idea = ideaService.findIdeaByKey("idea-3");
        Assert.assertNotNull(idea);
        Comment comment = Comment.builder()
                .idea(idea)
                .user(User.builder().userKey("second-user").build())
                .text("Comment 22222")
                .build();
        comment = ideaService.saveComment(idea, comment);
        Assert.assertNotNull(comment);
        Assert.assertNotNull(comment.getKey());
        comment = ideaService.replyComment(comment,
                Comment.builder()
                        .idea(idea)
                        .user(User.builder().userKey("third-user").build())
                        .text("Reply 33333")
                        .replyOn(comment)
                        .build());
        Assert.assertNotNull(comment.getReplies());
        Assert.assertNotEquals(0, comment.getReplies().size());
    }

}