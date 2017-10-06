package by.it.govor.jd01_05.taskA.task3;

/**
 * Created by User on 03.10.2017.
 */
public class Task3 {
    public static void task3() {
        double x=12.1;
        for (double i=-5; i<=12; i=i+3.75){
            double f=Math.exp(i*x)-3.45*i;
            System.out.printf("f=%10g \n",i,f);
        }

    }
}
