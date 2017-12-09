package by.it.shelkovich.project.java.dao;

import by.it.shelkovich.project.java.dao.dto.MainPageDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainPageDAO {

    public List<MainPageDTO> read(){
        List<MainPageDTO> mainPageData = new ArrayList<>();
            ResultSet rs = DataBase.exeSelectQuery("SELECT posts.description, likes, imageURL, username, posts.id FROM posts INNER JOIN users ON user_id = users.id");
        try {
            while(rs.next()){
                MainPageDTO dto = new MainPageDTO();
                dto.setPostId(rs.getLong("id"));
                dto.setDescription(rs.getString("description"));
                dto.setImageURL(rs.getString("imageURL"));
                dto.setLikes(rs.getLong("likes"));
                dto.setUsername(rs.getString("username"));
                dto.setCommentsCount(Long.parseLong(DataBase.exeSingleFieldSelectQuery("SELECT COUNT(*) as count FROM comments where post_id = " + dto.getPostId(), "count")));
                mainPageData.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainPageData;
    }
}
