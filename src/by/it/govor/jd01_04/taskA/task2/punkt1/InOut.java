package by.it.govor.jd01_04.taskA.task2.punkt1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 29.09.2017.
 */
public class InOut {

   public static int[]  Mas1(int kol) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите значения массива");
        String line = reader.readLine();
        String [] strMas = line.split(" ");
        int[] intMas = new int[strMas.length];
        for (int i=0; i<intMas.length;i++){
            intMas[i] =Integer.parseInt(strMas[i]);
        }
        int i=0;
        do {

            System.out.printf("IntrMas [% -3d] = %3d ",i,intMas[i]);
        if ((i+1)%kol==0) System.out.println();
            i++;
        } while(i<strMas.length);
        return intMas;
    }
}
