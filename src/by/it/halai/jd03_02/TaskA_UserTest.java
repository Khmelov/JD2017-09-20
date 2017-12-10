package by.it.halai.jd03_02;

import by.it.halai.jd03_02.beans.User;
import by.it.halai.jd03_02.crud.UsersCRUD;

import java.sql.SQLException;

public class TaskA_UserTest {

    public static void main(String[] args) {

        User user = new User(0, "login", "pass", "email", 2);

        try {
            //проверка CRUD для пользователей
            UsersCRUD userCRUD = new UsersCRUD();

            //создание
            user = userCRUD.create(user);
            System.out.println("create: " + user + "\n");

            //чтение
            System.out.println("read: " + userCRUD.read(user.getID()) + "\n");

            //обновление
            user.setLogin("loginUpdate");
            user = userCRUD.update(user);

            System.out.println("update: " + userCRUD.read(user.getID()) + "\n");
            //удаление
            if (userCRUD.delete(user))
                System.out.println("delete: " + user.getID() + "\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
