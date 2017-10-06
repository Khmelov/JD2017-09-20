package by.it.govor.jd01_02.taskA.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 25.09.2017.
 */
public class Mas {
   public static int[] masInt()throws  Exception{
        BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
        String text =string.readLine();
        String [] strMas = text.split(" ");
        int[] intMas = new int[strMas.length];
        for (int i=0; i<intMas.length;i++){
            intMas[i] =Integer.parseInt(strMas[i]);
        }
        return intMas;
    }
}
