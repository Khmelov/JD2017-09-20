package by.it.govor.jd01_02.taskB.task1;











import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 26.09.2017.
 */
public  class Matrix {
    public static  void matrix() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("введите число,которое имеет целочисленный корень(например 25)");
        int schet=0;
        int peremen = Integer.parseInt(reader.readLine());
        double a =Math.sqrt(peremen);
        int s = (int)a;
        int[][] mas = new int[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j <s; j++) {
                mas[i][j]=schet;
                schet++;
                System.out.print(mas[i][j]+" ");
            }
            System.out.println();
        }
    }

}
