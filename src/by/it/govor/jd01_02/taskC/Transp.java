package by.it.govor.jd01_02.taskC;

/**
 * Created by User on 26.09.2017.
 */
public class Transp {
    public static void transp(int mas[][], int size) {
        System.out.println("Транспонированная матрица(Задание №2)");
        int onmas[][]= new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
               // int z = mas[j][i];
               // mas[j][i] = mas[i][j];
               // mas[i][j] = z;
                onmas[j][i]=mas[i][j];
                onmas[i][j]=mas[j][i];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

               // System.out.print( mas[i][j]+" ");
                System.out.print( onmas[i][j]+" ");
            }
            System.out.println();
        }
    }
}
