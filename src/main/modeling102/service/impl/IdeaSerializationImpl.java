package main.modeling102.service.impl;

import main.modeling102.model.Comment;
import main.modeling102.model.Idea;
import main.modeling102.repository.IdeaFileSerializer;
import main.modeling102.service.IdeaService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author maruf
 * @since 10/26/17
 */
public class IdeaSerializationImpl implements IdeaService {
    private static final IdeaService ideaService = new IdeaSerializationImpl();
    private final IdeaFileSerializer ideaFileSerializer;

    private IdeaSerializationImpl() {
        this.ideaFileSerializer = IdeaFileSerializer.getStore();
    }

    public static IdeaService getInstance() {
        return ideaService;
    }

    @Override
    public Idea saveIdea(Idea idea) {
        Objects.requireNonNull(idea.getKey());
        Objects.requireNonNull(idea.getTitle());
        Objects.requireNonNull(idea.getText());
        return ideaFileSerializer.saveIdea(idea);
    }

    @Override
    public List<Idea> findIdeas() {
        return ideaFileSerializer.findAllIdea();
    }

    @Override
    public Idea findIdeaByKey(String key) {
        Objects.requireNonNull(key);
        return ideaFileSerializer.findIdeaByKey(key);
    }

    @Override
    public Comment saveComment(Idea idea, Comment comment) {
        Objects.requireNonNull(idea.getKey());
        Objects.requireNonNull(ideaFileSerializer.findIdeaByKey(idea.getKey()));
        Objects.requireNonNull(comment.getText());
        Objects.requireNonNull(comment.getUser());
        if (Objects.isNull(idea.getComments())) {
            idea.setComments(new LinkedHashSet<>());
        }
        comment.setKey(idea.getKey() + "-comment-" + (idea.getComments().size()));
        idea.getComments().add(comment);
        ideaFileSerializer.saveIdea(idea);
        return ideaFileSerializer.findCommentByKey(comment.getIdea().getKey(), comment.getKey());
    }

    @Override
    public Comment replyComment(Comment comment, Comment reply) {
        Objects.requireNonNull(comment.getKey());
        Objects.requireNonNull(comment.getIdea());
        Objects.requireNonNull(comment.getIdea().getKey());
        Objects.requireNonNull(reply.getText());
        Comment savedComment = ideaFileSerializer.findCommentByKey(comment.getIdea().getKey(), comment.getKey());
        Objects.requireNonNull(savedComment);
        if (Objects.isNull(savedComment.getReplies())) {
            savedComment.setReplies(new LinkedHashSet<>());
        }
        reply.setKey(savedComment.getKey() + "-reply-" + savedComment.getReplies().size());
        reply.setIdea(savedComment.getIdea());
        savedComment.getReplies().add(reply);
        ideaFileSerializer.saveIdea(savedComment.getIdea());
        return ideaFileSerializer.findCommentByKey(savedComment.getIdea().getKey(), savedComment.getKey());
    }
}
