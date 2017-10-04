package by.it.govor.jd01_05.taskA.task1;

import  static java.lang.Math.*;

public class Task1 {
    public static void task1() {
        double a =756.13;
        double x =0.3;

        double z =cos(pow((pow(x,2)+PI/6),5)) - x*Math.pow(a,3)- log(abs((a-1.12*x)/4));
        System.out.printf("%3f",z);

    }


}
