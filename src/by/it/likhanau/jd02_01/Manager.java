package by.it.likhanau.jd02_01;


public class Manager implements Runnable {

    @Override
    public void run() {
        int counterBuyers = 1;
        for (int i = 0; i < 120; i++) {
            int counterRandomNumOfBuyers = Util.generateRandomNumber(0, 2);
            for (int j = 0; j < counterRandomNumOfBuyers; j++) {
                boolean pensioner = false;
                int num = (int) (Math.random() * 10);
                if (num == 0 || num == 1 || num == 2) {
                    pensioner = true;
                }
                Thread thread = new Thread(new Buyer(counterBuyers++, pensioner));
                thread.start();
            }
        }

    }
}
