package by.it.govor.jd01_05.taskC;

import java.util.Random;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.*;
import static java.lang.Math.*;

/**
 * Created by User on 03.10.2017.
 */
public class Task6 {
     static void task6() {
         int k=0;
         Random random = new Random();

        double[] mas = new double[random.nextInt(20)+20];

         for (int i = 0; i <mas.length ; i++) {
             double x = random.nextInt(9)-5.33;
             mas[i] = power(pow(x,2)+4,5);
             if(mas[i]>3.5) k++;

             System.out.printf("[%2d] - %10f \n",i,mas[i]);
         }
         double[] mas2 = new double[k];
         int a=0;
         for (int i = 0; i <mas.length; i++) {
             if (mas[i]>3.5) {
                 mas2[a]=mas[i];
                 System.out.println();
                 System.out.printf("[%2d]  %10f",a,mas2[a]);
                 a++;

             }
         }
    }
}
