package by.it.meshchenko.project.java.bll.Admin;

import by.it.meshchenko.project.java.beans.*;
import by.it.meshchenko.project.java.beans.View.Admin.AdmUsersView;
import by.it.meshchenko.project.java.dao.DAO;

import java.util.List;

public class ConstructorAdmUsersView {

    public static AdmUsersView creator(DAO dao) {

        AdmUsersView res = null;
        List<User> users = dao.user.getAll("");
        List<Role> roles = dao.role.getAll("");
        if (users.size() > 0 && roles.size() > 0) {
            res = new AdmUsersView(users, roles);
        }
        return res;
    }
}
