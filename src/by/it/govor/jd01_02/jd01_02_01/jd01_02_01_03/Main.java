package by.it.govor.jd01_02.jd01_02_01.jd01_02_01_03;

/**
 * Created by User on 25.09.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Repetition rep = new Repetition();
       int itog = rep.repetition();
        if (itog!=0){
            System.out.println("Нет повторений в числе:"+itog);
        } else{
            System.out.println("Все числа имеют повторение");
        }
    }
}
