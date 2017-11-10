package by.it.mustaphin.jd02_01_AND_jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

class Market implements Runnable {

    static LinkedBlockingQueue<Buyer> buyers = new LinkedBlockingQueue<>(30);
    List<Cashier> cashiers = new ArrayList<>();
    Timer timer;
    boolean frequentlyCreate = false;

    Market() {
        Thread thread = new Thread(this);
        timer = new Timer();
        thread.start();
        openCashes();
    }

    void buyerCreate(String name) {
        boolean pensioneer = false;
        if (((Math.random() * 10) + 1) <= 2.5) {
            pensioneer = true;
        }
        new Buyer(name, pensioneer);
    }

    @Override
    public void run() {
        synchronized (timer) {
            timer.notify();
        }
        int countName = 0;
        while (timer.letIn) {
            if (!frequentlyCreate && (buyers.size() <= (timer.currentSecond + 10))) {
                System.out.println("NORMAL SPEED");
                for (int k = (int) (Math.random() * 3); k > 0; k--) {
                    buyerCreate(String.valueOf(++countName));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (frequentlyCreate && (buyers.size() <= (40 + (30 - timer.currentSecond)))) {
                System.out.println("TURBO SPEED");
                for (int k = (int) (Math.random() * 40) + 30; k > 0; k--) {
                    buyerCreate(String.valueOf(++countName));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Timer extends Thread {
        boolean letIn = true;
        volatile int currentSecond;

        public Timer() {
            start();
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 2; j++)
                for (int i = 0; i < 60; i++) {
                    currentSecond = i;
                    if (((i / 30 == 1) & (i % 30 == 0)) || ((i / 30 == 2) & (i % 30 == 0))) {
                        frequentlyCreate = !frequentlyCreate;
                        System.out.println(i % 30 + " " + frequentlyCreate + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            letIn = false;
        }
    }

    void openCashes() {
        for (int i = 0; i < 5; i++) {
            cashiers.add(new Cashier("Кассир " + (i + 1)));
        }
        while (true) {
            if (buyers.size() > 0) {
                synchronized (cashiers.get(0)) {
                    cashiers.get(0).notify();
                }
            } else {
                cashiers.get(0).canClose = true;
            }
            if (buyers.size() > 5) {
                synchronized (cashiers.get(1)) {
                    cashiers.get(1).notify();
                }
            } else {
                cashiers.get(1).canClose = true;
            }
            if (buyers.size() > 10) {
                synchronized (cashiers.get(2)) {
                    cashiers.get(2).notify();
                }
            } else {
                cashiers.get(2).canClose = true;
            }
            if (buyers.size() > 15) {
                synchronized (cashiers.get(3)) {
                    cashiers.get(3).notify();
                }
            } else {
                cashiers.get(3).canClose = true;
            }
            if (buyers.size() > 20) {
                synchronized (cashiers.get(4)) {
                    cashiers.get(4).notify();
                }
            } else {
                cashiers.get(4).canClose = true;
            }
        }
    }
}
