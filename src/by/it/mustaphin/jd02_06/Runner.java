package by.it.mustaphin.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.writeLog("ERROR");
    }
}
