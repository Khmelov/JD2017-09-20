package by.it.dubrova.jd02_02;

import by.it.akhmelev.jd01_10.calc_v2_demo.Runner;

public class Cashier implements Runnable {

    private int casNum;

    Cashier(int casNum){
        this.casNum = casNum;
        Thread t = new Thread(this);
        t.start();
    }

    public int getCasNum() {
        return casNum;
    }

    @Override
    public void run() {
        while (RunnerA.countBuyers > 0){
            RunnerA.dec();

            try {
                Thread.sleep((int) (Math.random()*2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Завершили обслуживание очередного покупателя в кассе " + getCasNum());
        }
    }
}
