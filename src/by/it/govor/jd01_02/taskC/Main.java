package by.it.govor.jd01_02.taskC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 26.09.2017.
 */
public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите значение");
        int size = Integer.parseInt(reader.readLine());
        int mas[][] = Mas.mas(size);
        Sum.sum(mas,size);
        Transp.transp(mas,size);
        Turn.turn(mas,size);
        MaxDelete.delete(mas,size);
        Reshuffle.reshulffle(mas,size);
        Sort.sort(mas,size);

    }
}
