package by.it.likhanau.jd02_01;


import java.util.ArrayList;
import java.util.List;

class Buyer implements IBuyer, IUseBucket, Runnable {
    private boolean pensioner;
    private int number;

    List<Double> basket = new ArrayList<>();

    public Buyer(int number, boolean pensioner) {
        this.number = number;
        this.pensioner = pensioner;
    }

    @Override
    public String toString() {
        return "Buyer # " + this.number + (this.pensioner ? " (пенсионер)" : "");
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " has entered the shop.");
    }

    @Override
    public String chooseGoods() {
        System.out.println(this + " is choosing goods.");
        int pause = Util.generateRandomNumber(500, 2_000);
        if (pensioner) {
            pause *= 1.5;
        }
        Util.makeThreadSleep(pause);
        return Goods.getRandomGood();
    }

    @Override
    public void goToOut() {
        System.out.println(this + " has left the shop.");
    }


    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        putGoodsToBucket();
        goToOut();
    }

    @Override
    public void takeBucket() {
        System.out.println(this + " has taken a basket.");
        int pause = Util.generateRandomNumber(100, 200);
        if (pensioner) {
            pause *= 1.5;
        }
        Util.makeThreadSleep(pause);
    }

    @Override
    public void putGoodsToBucket() {
        for (int i = 0; i < Util.generateRandomNumber(1, 4); i++) {
            String keyGoods = chooseGoods();
            this.basket.add(Goods.goods.get(keyGoods));
            System.out.println(this + " has added " + keyGoods + ". The price is " + Goods.goods.get(keyGoods) + " .");
            int pause = Util.generateRandomNumber(100, 200);
            if (pensioner) {
                pause *= 1.5;
            }
            Util.makeThreadSleep(pause);
        }
    }
}
