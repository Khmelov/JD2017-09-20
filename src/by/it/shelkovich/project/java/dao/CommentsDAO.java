package by.it.shelkovich.project.java.dao;

import by.it.shelkovich.project.java.dao.dto.CommentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentsDAO {

    public List<CommentDTO> read(long postId){
        List<CommentDTO> comments = new ArrayList<>();
        ResultSet rs = DataBase.exeSelectQuery("SELECT username, text FROM comments INNER JOIN users ON users.id = comments.user_id WHERE comments.post_id = "+postId);
        try {
            while(rs.next()){
                CommentDTO dto = new CommentDTO();
                dto.setUsername(rs.getString("username"));
                dto.setText(rs.getString("text"));
                comments.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
}
