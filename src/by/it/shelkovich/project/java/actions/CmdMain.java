package by.it.shelkovich.project.java.actions;

import by.it.shelkovich.project.java.dao.DAO;
import by.it.shelkovich.project.java.dao.MainPageDAO;
import by.it.shelkovich.project.java.dao.dto.MainPageDTO;
import by.it.shelkovich.project.java.dao.entities.Post;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdMain extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        try {
            List<MainPageDTO> mainPageData = new MainPageDAO().read();
            request.setAttribute("mpData", mainPageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
