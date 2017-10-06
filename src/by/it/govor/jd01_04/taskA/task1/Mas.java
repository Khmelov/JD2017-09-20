package by.it.govor.jd01_04.taskA.task1;

/**
 * Created by User on 28.09.2017.
 */
public class Mas {
    public static void OneMas() {
        int[][] mas = new int[9][9];
        int i=0;
            while( i!=mas.length) {
                for (int j = 0; j < mas.length; j++) {
                    int sum = (i + 1) * (j + 1);
                    int ja = j + 1;
                    //  System.out.print(i+1 + "*" + J + "=" + sum+ "\t");
                    System.out.printf("%1d * %1d = %2d", i + 1, ja, sum);
                }

            i++;
            System.out.println();
        }
    }



}
