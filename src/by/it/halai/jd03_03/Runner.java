package by.it.halai.jd03_03;

import by.it.halai.jd03_03.beans.Role;
import by.it.halai.jd03_03.beans.User;
import by.it.halai.jd03_03.dao.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Создаем базу");
        DbInit.main(null);

        System.out.println("\n\nЗаполняем таблицы из xml файлов с использованием DAO");
        JaxBfillTables.addTableData();


        System.out.println("\n\nВыводим пользователей с их ролями с использованием DAO");
        DAO dao = DAO.getInstance();
        try {

            List<User> users = dao.user.getAll();
            for (User user : users) {
                Role role = dao.role.read(user.getFK_roles());
                System.out.println(String.format("User: %-15s has role: %-15s", user.getLogin(), role.getRole()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("\n\nНажмите ВВОД, чтобы удалить базу >");
        getCommandLine();

        DbReset.main(null);
        System.out.println("\nУдалили базу");
    }

    private static void getCommandLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
