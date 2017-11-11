package by.it.halai.jd02_01;

/**
 * Vitaly Halai
 */
public class Helper {
    static int random(int from, int to) {
        return (int) Math.round(Math.random() * (to - from) + from);
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
