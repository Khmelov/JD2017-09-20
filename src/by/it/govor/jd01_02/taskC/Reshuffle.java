package by.it.govor.jd01_02.taskC;

/**
 * Created by User on 26.09.2017.
 */
public class Reshuffle {

    public static  void reshulffle(int[][] mas, int size) {
        System.out.println();
        System.out.println("Перенос строки и столбца на 1х1 (Задание №5)");
        int[][] onmas= new int[size][size];
int min=size+1;
        int ia=0,ja=0;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
            if (mas[i][j]<min){
                min=mas[i][j];
                ia=i;
                ja=j;
            }
            }
        }
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if (i==0){
                    onmas[ia][j]=mas[i][j];
                    onmas[i][j]=mas[ia][j];

                }
            }
        }
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if (j==0){
                    int tham=mas[i][j];
                    onmas[i][j]=mas[i][ja];
                    onmas[i][ja]=mas[i][j];
                   // mas[i][j]=mas[i][Ja];
                  //  mas[i][Ja]=tham;
                }
            }
        }
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(onmas[i][j]+" ");
            }
            System.out.println();
        }
    }
}
