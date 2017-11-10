package by.it.mustaphin.calc;

import java.io.*;

public class MathException extends Exception {

    String src = System.getProperty("user.dir") + "/src/by/it/mustaphin/calc/log.txt";

    public MathException(String message) {
        super(message);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(src)))) {
            bw.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
