package by.it.govor.jd01_02.taskC;

import java.util.Random;

/**
 * Created by User on 26.09.2017.
 */
public class Mas {
    public static int[][] mas(int size)throws Exception {
        System.out.println("Массив");
        int[][] mas =new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size ; j++) {

                mas[i][j]= random.nextInt(size*2)-size;
                System.out.print(mas[i][j]+" ");
            }
            System.out.println();
        }
        return mas;

    }
}
