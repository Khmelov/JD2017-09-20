package by.it.shelkovich.project.java.dao.dto;

import by.it.shelkovich.project.java.dao.entities.Comment;

import java.util.List;

public class CommentDTO {
    Long postId;
    String username;
    String text;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CommentDTO() {

    }
}
