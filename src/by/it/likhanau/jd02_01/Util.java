package by.it.likhanau.jd02_01;


public class Util {

    static int generateRandomNumber(int min, int max) {
        int number = max - min;
        return (int) Math.round(Math.random() * number + min);
    }

    static void makeThreadSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
