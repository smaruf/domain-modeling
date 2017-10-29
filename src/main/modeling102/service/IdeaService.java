package service;


import model.Comment;
import model.Idea;

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

    Comment replyComment(Comment comment, Comment reply);

}
