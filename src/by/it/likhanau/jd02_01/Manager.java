package by.it.likhanau.jd02_01;


public class Manager implements Runnable {

    @Override
    public void run() {
        int counterBuyers = 1;
        for (int i = 0; i < 120; i++) {
            int counterRandomNumOfBuyers = Util.generateRandomNumber(0, 2);
            for (int j = 0; j < counterRandomNumOfBuyers; j++) {
                Thread thread = new Thread(new Buyer(counterBuyers++));
                thread.start();
            }
        }

    }
}
