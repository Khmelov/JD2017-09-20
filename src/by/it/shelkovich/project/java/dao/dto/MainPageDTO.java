package by.it.shelkovich.project.java.dao.dto;

import by.it.shelkovich.project.java.dao.DAO;
import by.it.shelkovich.project.java.dao.entities.Comment;
import by.it.shelkovich.project.java.dao.entities.Post;
import by.it.shelkovich.project.java.dao.entities.User;

import java.sql.SQLException;
import java.util.List;

public class MainPageDTO {
    private String username;
    private Long postId;
    private String description;
    private String imageURL;
    private Long likes;
    private Long commentsCount;

    public MainPageDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }
}
