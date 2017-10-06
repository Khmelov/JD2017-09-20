package by.it.govor.jd01_04.taskB;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 29.09.2017.
 */
public class Mas {
    public static void mas() throws Exception {


        BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите Ф людей");
        String text = string.readLine();
        String[] strMas = text.split(" ");
        int size = strMas.length;
        int[][] mas = new int[size][4];
        for (int i = 0; i <size; i++) {
            for (int j = 0; j <4 ; j++) {
               int k=j+1;
               System.out.println("Введите зарплату "+strMas[i]+" за "+k+" квартал");
              mas[i][j]  = Integer.parseInt(string.readLine());


            }
        }
        System.out.println();
        int sum=0;
        for (int i = 0; i <size ; i++) {
            System.out.print("Имя: "+strMas[i]);
            sum=0;
            for (int j = 0; j <5 ; j++) {

                if(j!=4) {

                    System.out.printf(" зарплата за %1d квартал = %1d ",j+1, mas[i][j]);
                    sum=sum+mas[i][j];
                }else {
                    System.out.println(" Сумма ="+sum);
                }
            }
        }
        for (String q:strMas) {
            System.out.print(q);

        }//просто,что бы был foreach)))
    }
}
