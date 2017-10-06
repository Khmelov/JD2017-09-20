package by.it.govor.jd01_02.taskB.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 26.09.2017.
 */
public class Month {
    public static void month() throws  Exception {
        System.out.println("Введите номер месяца");
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (number>0 && number<=12){
        switch (number) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("Fevruary");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
        }
        }else{
            System.out.println("Введено некорректное число");
        }
    }
}
