package by.it.halai.jd02_01;

import java.util.HashMap;

/**
 * @author Vitaly Halai
 */
class Buyer extends Thread implements IBuyer, IUseBacket {

    public int number;
    public boolean pensioneer;
    HashMap<String, Double> backet = new HashMap<>();


    Buyer(int number) {
        super("Buyer № ".concat(Integer.toString(number)));
        if (number % 4 == 0) {
            pensioneer = true;
            System.out.println("Buyer № ".concat(Integer.toString(number)) + " is a pensioneer");
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {

        System.out.println(this + " start choose goods");
        int goodsCount = Helper.random(1, 4);
        for (int i = 0; i < goodsCount; i++) {
            int timeout;
            if (pensioneer == true) {
                timeout = (int) (Helper.random(100, 1000) * 1.5);
            } else {
                timeout = Helper.random(100, 1000);
            }

            System.out.println(this + " timeout=" + timeout);
            String keyGood = Goods.items.randomGood();
            double price = Goods.items.get(keyGood);
            System.out.printf("%s choose %s, price=%f\n",
                    this, keyGood, price);
            backet.put(keyGood, price);
            Helper.sleep(timeout);
        }
        System.out.println(this + " stop choose goods");
    }

    @Override
    public void takeBacket() {
        int timeout;
        if (pensioneer == true) {
            timeout = (int) (Helper.random(100, 200) * 1.5);
        } else {
            timeout = Helper.random(100, 200);
        }
        System.out.println(this + " timeout=" + timeout);
        System.out.println(this + " take a Backet");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout;
        if (pensioneer == true) {
            timeout = (int) (Helper.random(100, 200) * 1.5);
        } else {
            timeout = Helper.random(100, 200);
        }
        System.out.println(this + " timeout=" + timeout);
        System.out.println(this + " put " + backet + " to the backet");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " out from market");
    }
}
