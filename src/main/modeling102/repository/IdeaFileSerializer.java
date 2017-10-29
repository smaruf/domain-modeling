package main.modeling102.repository;

import main.modeling102.model.Comment;
import main.modeling102.model.Idea;

import java.io.*;
import java.util.*;

/**
 * @author maruf
 * @since 10/26/17
 */
public enum IdeaFileSerializer {
    STORE;
    private List<Idea> ideaList = new LinkedList<>();
    private String directory = "/store/";
    private String fileName = "ideas";
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;

    public static IdeaFileSerializer getStore() {
        return STORE;
    }

    public Idea saveIdea(Idea idea) {
        Idea savedIdea = findIdeaByKey(idea.getKey());
        if (Objects.nonNull(savedIdea)) {
            savedIdea.setTitle(idea.getTitle());
            savedIdea.setComments(idea.getComments());
            savedIdea.setText(idea.getText());
            savedIdea.setUser(idea.getUser());
            savedIdea.setVotes(idea.getVotes());
        } else {
            ideaList.add(idea);
        }

        ideaList = storeList(ideaList);

        return idea;
    }

    private List<Idea> storeList(List<Idea> ideaList) {
        try {
            new File(directory).mkdir();
            File file = new File(directory + fileName);
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(ideaList);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadList();
    }

    public Idea findIdeaByKey(String key) {
        if (ideaList.isEmpty()) {
            ideaList = loadList();
        }
        for (Idea idea : ideaList) {
            if (idea.getKey().equalsIgnoreCase(key)) {
                return idea;
            }
        }
        return null;
    }

    private List<Idea> loadList() {
        try {
            new File(directory).mkdir();
            File file = new File(directory + fileName);
            fileInputStream = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            List<Idea> ideas = (List<Idea>) in.readObject();
            in.close();
            if (Objects.nonNull(ideas)) {
                return ideas;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Idea> findAllIdea() {
        if (ideaList.isEmpty()) {
            ideaList = loadList();
        }
        return ideaList;
    }

    public Comment findCommentByKey(String ideaKey, String commentKey) {
        Idea idea = findIdeaByKey(ideaKey);
        if (Objects.nonNull(idea)) {
            return getCommentByKey(idea.getComments(), commentKey);
        } else {
            return null;
        }

    }

    private Comment getCommentByKey(Set<Comment> comments, String commentKey) {
        if (!comments.isEmpty()) {
            for (Comment comment : comments) {
                if (comment.getKey().equalsIgnoreCase(commentKey)) {
                    return comment;
                }
            }
        }
        return null;
    }
}
