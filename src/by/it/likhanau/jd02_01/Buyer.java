package by.it.likhanau.jd02_01;


import java.util.ArrayList;
import java.util.List;

class Buyer implements IBuyer, IUseBucket, Runnable {
    private int number;
    List<Double> basket = new ArrayList<>();

    public Buyer(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Buyer # " + number;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " has entered the shop.");
    }

    @Override
    public String chooseGoods() {
        System.out.println(this + " is choosing goods.");
        Util.makeThreadSleep(Util.generateRandomNumber(500, 2_000));
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
        Util.makeThreadSleep(Util.generateRandomNumber(100, 200));
        System.out.println(this + " has taken a basket.");
    }

    @Override
    public void putGoodsToBucket() {
        for (int i = 0; i < Util.generateRandomNumber(1, 4); i++) {
            String keyGoods = chooseGoods();
            this.basket.add(Goods.goods.get(keyGoods));
            System.out.println(this + " has added " + keyGoods + ". The price is " + Goods.goods.get(keyGoods) + " .");
            Util.makeThreadSleep(Util.generateRandomNumber(100, 200));
        }
    }
}
