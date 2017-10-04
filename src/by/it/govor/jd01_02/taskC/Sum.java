package by.it.govor.jd01_02.taskC;

/**
 * Created by User on 26.09.2017.
 */
public class Sum {

    public static void sum(int[][] mas, int size) {
        System.out.println("Сумма между двумя положительными числами(Задание №1)");
        int sum=0, flag=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size ; j++) {
                if (mas[i][j]>0) {
                    flag++;
                }
                if (flag ==1){
                    sum+=mas[i][j];}
                    if (flag==2){
                        flag=3;
                        sum+=mas[i][j];
                        System.out.println(i+1+")"+sum);
                    }

            }
            flag=0;
            sum=0;
        }
    }
}
