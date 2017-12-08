package by.it.ali.jd03_03;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException{
        DAO dao=DAO.getDAO();
//        Tickets ad=new Tickets("Moscow","s7","17-08-22",112,2);
//        System.out.println("All-------------------------");
//        System.out.println(dao.ticket.getAll(""));
//
//        dao.ticket.create(ad);
//        System.out.println("-------- Create ------------");
//        System.out.println(dao.ticket.getAll(""));
//
//        ad.setCompany("!!!!");
//        dao.ticket.update(ad);
//        System.out.println("-------- Update ------------");
//        System.out.println(dao.ticket.getAll(""));
//
//        dao.ticket.delete(ad);
//        System.out.println("-------- Delete ------------");
//        System.out.println(dao.ticket.getAll(""));
        User us = new User("11","11111", "111111@1111",1,1);
        System.out.println(dao.user.getAll(""));

        dao.user.create(us);
       System.out.println(dao.user.getAll(""));


        us.setEmail("string@tut.by");
       // System.out.println(us);
        dao.user.update(us);
        System.out.println(dao.user.getAll(""));
        dao.user.delete(us);
        System.out.println(dao.user.getAll(""));
    }
}
