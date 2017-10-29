package main.modeling102.service;

import main.modeling102.model.Comment;
import main.modeling102.model.Idea;

import java.util.List;

/**
 * @author maruf
 * @since 10/26/17
 */
public interface IdeaService {
    Idea saveIdea(Idea idea);

    List<Idea> findIdeas();

    Idea findIdeaByKey(String key);

    Comment saveComment(Idea idea, Comment comment);

    void replyComment(Comment comment, Comment reply);

}
