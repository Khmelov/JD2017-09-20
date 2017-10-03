package by.it.govor.jd01_04.jd01_04_01;


import by.it.govor.jd01_04.jd01_04_01.jd01_04_01_02.jd01_04_01_02_01.InOut;
import by.it.govor.jd01_04.jd01_04_01.jd01_04_01_02.jd01_04_01_02_02.Sort;

/**
 * Created by User on 29.09.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
      int kol =  Kol.kol();
     int[] mas= InOut.Mas1(kol);
        Sort.sort(mas,kol);
    }
}
