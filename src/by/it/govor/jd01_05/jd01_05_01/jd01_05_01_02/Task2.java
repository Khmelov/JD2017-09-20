package by.it.govor.jd01_05.jd01_05_01.jd01_05_01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import  static java.lang.Math.*;
public class Task2 {
    public static void task2() throws IOException {
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(reader.readLine());
        double b =0.371;
        double y = tan(pow(a+b,2))-cbrt(a+1.5)+a*pow(b,5)-b/log(a*a);
        System.out.printf("%10f",y);

    }


}
