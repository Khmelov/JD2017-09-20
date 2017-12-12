package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

class Utils {


    static User getUserFromSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) return null;
        Object o = session.getAttribute("user");
        if (o == null) return null;
        return (User) o;
    }


    private static final String SAVE_DIR = "user_images";

    static private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }

    /**
     * @see <a href=http://www.codejava.net/java-ee/servlet/java-file-upload-example-with-servlet-30-api>
     * http://www.codejava.net/java-ee/servlet/java-file-upload-example-with-servlet-30-api
     * </a>
     */
    static String uploadFile(HttpServletRequest request, String FieldName) {
        //полный путь к приложению
        String appPath = request.getServletContext().getRealPath("");
        //путь к каталогу файлов с загрузкой
        String savePath = appPath + File.separator + SAVE_DIR;

        //поиск имени файла в поле FieldName и запись при успехе
        String fileName = "no_img.jpg";
        try {
            for (Part part : request.getParts()) {
                if (part.getName().equals(FieldName)) {
                    fileName = extractFileName(part);
                    part.write(savePath + File.separator + fileName);
                }
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        request.setAttribute(Messages.MESSAGE, "Upload successful" + fileName);
        return SAVE_DIR + '/' + fileName;
    }
}
