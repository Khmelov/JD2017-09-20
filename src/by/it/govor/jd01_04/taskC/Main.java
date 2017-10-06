package by.it.govor.jd01_04.taskC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 29.09.2017.
 */
public class Main {
    public static void main(String[] args)throws IOException {
       // System.out.println(Arrays.toString( Sort.sort(new int[]{2,3,4,61,2,5,7},new int[]{4,7,4,2,1,8})));
     int[] mas = Sort.sort();
        System.out.println("Введите элемент массива");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        System.out.println(Search.search(k,0,mas.length,mas));
    }
}
