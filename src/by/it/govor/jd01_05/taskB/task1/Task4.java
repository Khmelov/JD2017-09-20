package by.it.govor.jd01_05.taskB.task1;

import static java.lang.Math.*;

/**
 * Created by User on 03.10.2017.
 */
public class Task4 {
    public static void task4() {
        double y =0;
        for (int i = 6; i <=11 ; i++) {
            for (int j = 1; j <=8 ; j++) {
             y = pow((j+2),1.3*i);
            }
        }
        System.out.printf("%7f",y);
    }

}
