package by.it.govor.jd01_04.jd01_04_01.jd01_04_01_02.jd01_04_01_02_03;

/**
 * Created by User on 29.09.2017.
 */
public class sim {
    public static void main(int[] mas, int kol) {

        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%3d ", i, mas[i]);
            if ((i + 1) % kol == 0) System.out.println();
        }
    }
}
