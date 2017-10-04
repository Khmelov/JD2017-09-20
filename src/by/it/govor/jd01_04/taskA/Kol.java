package by.it.govor.jd01_04.taskA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 29.09.2017.
 */
public class Kol {
    public static int  kol() throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Введите кол-во колонок");
        int kolonka =  Integer.parseInt(reader.readLine());
        return kolonka;
    }
}
