package by.it.shelkovich.project.java.actions;

import by.it.shelkovich.project.java.Hash;
import by.it.shelkovich.project.java.dao.DAO;
import by.it.shelkovich.project.java.dao.entities.Post;
import by.it.shelkovich.project.java.dao.entities.User;
import by.it.shelkovich.project.java.servlets.RequestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

public class CmdPublish extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest request) {
        if (RequestUtils.isPost(request)) {
            DAO dao = DAO.getInstance();
            User sessionUser = (User)request.getSession().getAttribute("user");
            String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
            Part filePart = null; // Retrieves <input type="file" name="file">
            try {
                filePart = request.getPart("imageFile");
                String fileName =  getSubmittedFileName(filePart);
                InputStream fileContent = filePart.getInputStream();

                File file = new File(request.getServletContext().getRealPath("/resources/images/")+ Hash.md5(fileName)+".jpg");
                OutputStream os = new FileOutputStream(file);
                int buffer;
                while ((buffer = fileContent.read()) != -1){
                    os.write(buffer);
                }
                os.flush();
                os.close();
                fileContent.close();

                Post post = new Post();
                post.setDescription(description);
                post.setImageURL(Hash.md5(fileName)+".jpg");
                post.setUser_id(sessionUser.getId());
                post.setLikes(0);
                dao.postDAO.create(post);
                return Actions.MAIN.command;
            } catch (Exception e) {
                e.printStackTrace();
                return Actions.ERROR.command;
            }

        }
        return null;
    }

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
