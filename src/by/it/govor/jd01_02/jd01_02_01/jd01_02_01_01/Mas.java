package by.it.govor.jd01_02.jd01_02_01.jd01_02_01_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 25.09.2017.
 */
 class Mas {


   protected static String[] masStr()throws  Exception{
        BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
        String text =string.readLine();
        String [] strMas = text.split(" ");

        return strMas;
    }

}