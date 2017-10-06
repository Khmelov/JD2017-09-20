package by.it.govor.jd01_02.taskB.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 26.09.2017.
 */
public class PowEquation {
    public static void StrpowEquation() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число a");
        int a = Integer.parseInt(reader.readLine());
        System.out.println("Введите число b");
        int b = Integer.parseInt(reader.readLine());
        System.out.println("Введите число с");
        int c = Integer.parseInt(reader.readLine());
        int d =(int)Math.pow(b,2)-4*a*c;
        if (d>0){
            double x1 = (-1*b+Math.sqrt(d))/2;
            double x2 = (-1*b-Math.sqrt(d))/2;
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);
        }else if(d==0){
            double x1 = (-1*b)/2;
            System.out.println("x1=x2="+x1);
        }else {
            System.out.println("ет корней");
        }

    }
}
