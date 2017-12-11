package by.it.akhmelev.jd03_02.classwork.test_crud;

import by.it.akhmelev.jd03_02.classwork.beans.Role;
import by.it.akhmelev.jd03_02.classwork.crud.RoleCRUD;

import java.sql.SQLException;

public class TestRole {

    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD=new RoleCRUD();
        Role role=new Role(0,"Administrator");
        roleCRUD.create(role);
    }


}
