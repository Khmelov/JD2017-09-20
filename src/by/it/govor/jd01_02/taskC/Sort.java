package by.it.govor.jd01_02.taskC;

/**
 * Created by User on 26.09.2017.
 */
public class Sort {
   protected static void sort(int[][] mas, int size) {
        System.out.println("Все нули в конце массива(Задание №6)");
        int y=0;
        int a=0;
        int b=0;
int onmas[][]= mas;
        System.out.println();

        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if (mas[i][j]==y){

                    a=0;

                        if (mas[i][size - 1 - b] != 0) {
                            int r = mas[i][j];
                           // mas[i][j] = mas[i][size - 1 - b];
                           // mas[i][size - 1 - b] = r;
                            onmas[i][j] = onmas[i][size - 1 - b];
                            onmas[i][size - 1 - b] = r;

                        }
                    }
                }

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(onmas[i][j] + " ");
            }
            System.out.println();
        }
        }

    }

