package by.it.mustaphin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Singleton {

    static {
        System.getProperty("user.dir")+"/src/by/it/mustaphin/jd02_06/";
        Path path = Paths.get();
    }

    private static volatile Singleton instance;

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
}
