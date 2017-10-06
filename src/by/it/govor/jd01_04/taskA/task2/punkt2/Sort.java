package by.it.govor.jd01_04.taskA.task2.punkt2;

import java.util.Arrays;

/**
 * Created by User on 29.09.2017.
 */
public class Sort {
    public static void sort(int[] mas,int kol) {
        System.out.println();
        int[] sortMas = mas;
        int a = mas[0];
        int b = mas[mas.length-1];
        Arrays.sort(sortMas);
        for (int i = 0; i < sortMas.length; i++) {
            System.out.printf("%3d ", i, sortMas[i]);
            if ((i + 1) % kol == 0) System.out.println();
        }
        System.out.println( );
        System.out.println(Arrays.binarySearch(sortMas,a) );
        System.out.println(Arrays.binarySearch(sortMas,b) );
    }
}
