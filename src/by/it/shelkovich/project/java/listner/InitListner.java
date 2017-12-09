package by.it.shelkovich.project.java.listner;

import by.it.shelkovich.project.java.dao.DataBase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.MalformedURLException;
import java.sql.ResultSet;

public class InitListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //ResultSet rs = DataBase.exeSelectQuery("SELECT * FROM users");
        //if (rs == null){
            System.out.println("try to init DB");
            DataBase.initDataBase(servletContextEvent.getServletContext().getResourceAsStream("/resources/shelkovich.sql"));

        //}
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
