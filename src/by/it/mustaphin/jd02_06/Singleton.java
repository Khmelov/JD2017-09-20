package by.it.mustaphin.jd02_06;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Singleton {

    private static volatile Singleton instance;
    private String path = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd02_06/log.txt";


    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }

    void writeLog(String text) {
        Date date = new Date();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), true))) {
            bw.write(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date) + " : " + text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
