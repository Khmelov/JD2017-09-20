package by.it.govor.jd01_05.taskB.task2;

import static java.lang.Math.*;

/**
 * Created by User on 03.10.2017.
 */
public class Task5 {

    public static void  task5() {
        System.out.println();
        double r =0.491*pow(10,4);
        double z=0;
        for (double i = 3.5; i <15 ; i= i+1.5) {
            if(i-1<0){z= 3.8*sin(i);

        }else{if(i-1>=3){
                z=pow(i,3)-i;
            } else{
                z= pow((2/(i+1))+sin(PI/6),5);
            }
        }
        double y =pow(4.67,z-1.4*r);
            System.out.println("["+i+"] "+y);
        }
        
    }
}
