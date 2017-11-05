package by.it.likhanau.jd02_01;


public class Runner {
    public static void main(String[] args) {
        Runnable manager = new Manager();
        Thread thread = new Thread(manager);
        thread.start();
    }
}