package by.it.meshchenko.jd03_01;

import java.sql.*;

public class B_ShowUsers {
    public static void main(String[] args) {
//        //наболее надежный способ загрузки драйвера
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error loading driver: " + e);
//        }
//        //второй способ загрузки драйвера
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {e.printStackTrace();}

        //в некоторых случаях можно вообще ничего не загружать (например при запуске в IDEA)
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            //получаем пользователей

            ResultSet roles = statement.executeQuery("select * from crm_roles;");

            //Object[] arr = (Object [])roles.getArray("Id").getArray();
            Roles[] arrRole = new Roles[3];
            int i = 0;
            while (roles.next()) {
                arrRole[i] = new Roles(roles.getString("Role"), roles.getInt("Id"));
                //System.out.println(arrRole[i].getId() + arrRole[i].getRole());
                i++;
            }

            String roleStr = "";
            ResultSet users = statement.executeQuery("select * from crm_users;");
            while (users.next()) {
                roleStr = "";
                for(int j = 0; j < arrRole.length; j++){
                    if(users.getInt("RoleId") == arrRole[j].getId()) {
                        roleStr = arrRole[j].getRole();
                        break;
                    }
                }
                String out = String.format("%-32s %-15s %-15s",users.getString("Email"),
                        users.getString("Name"), roleStr);
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Roles{

    private String Role;
    private Integer Id;

    public Roles(String role, Integer id) {
        Role = role;
        Id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}