package by.it.govor.jd01_04.taskA;


import by.it.govor.jd01_04.taskA.task2.punkt1.InOut;
import by.it.govor.jd01_04.taskA.task2.punkt2.Sort;


public class Main {
    public static void main(String[] args) throws Exception {
      int kol =  Kol.kol();
     int[] mas= InOut.Mas1(kol);
        Sort.sort(mas,kol);
    }
}
