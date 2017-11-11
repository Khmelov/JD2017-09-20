package by.it.halai.jd02_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitaly Halai
 */
public class Main {

    public static void main(String[] args) {

        int counterBuyers = 0;

        List<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {  //счетчик количества минут
            int n = 0;
            for (int i1 = 0; i1 < 30; i1++) {  //первые 30 секунд каждой минуты

                int currentBuyerCount = Helper.random(0, 2);
                for (int j = 0; j < currentBuyerCount; j++) {
                    Buyer b = new Buyer(++counterBuyers);
                    b.start();
                    buyers.add(b);
                    n++;
                    Helper.sleep(1000);
                }
            }
            System.out.printf("Количетсво посетителей в первые 30 секунд %d -й минуты равно %d\n", i + 1, n);
            for (int i2 = 30; i2 < 61; i2++) {  //вторые 30 секунд каждой минуты
                if (n <= 40 + (30 - i2)) {
                    Buyer b = new Buyer(++counterBuyers);
                    b.start();
                    buyers.add(b);
                    n++;
                    Helper.sleep(1000);
                }
            }
            System.out.printf("Количетсво посетителей во вторые 30 секунд %d -й минуты равно %d\n", i + 1, n);
            Helper.sleep(1000);
        }
        for (Buyer buyer : buyers)
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Обслуживание завершено!");
    }
}
