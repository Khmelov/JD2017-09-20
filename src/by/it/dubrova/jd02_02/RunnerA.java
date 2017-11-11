package by.it.dubrova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class RunnerA {

    static int countBuyers;
    synchronized static void dec(){
        System.out.println("Обслужавается покупатель " + countBuyers);
        --countBuyers;
    }

    public static void main(String[] args) {

        // make buyers
        List<Buyer> buyer = new ArrayList<>();
        // count buyers from 5 to 25
        countBuyers = (int)(Math.random()*25 + 5);

        System.out.println(countBuyers);
        for (int i = 0; i < 5; i++)
            new Cashier(i);
    }
}
