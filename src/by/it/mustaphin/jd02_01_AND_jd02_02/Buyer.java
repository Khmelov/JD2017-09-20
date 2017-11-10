package by.it.mustaphin.jd02_01_AND_jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer implements Runnable, IBuyer, IUseBucket {

    Thread thread;
    List<Goods> bucket = new ArrayList<>();
    String name;
    long k;

    Buyer(String name, boolean pensioneer) {
        this.name = name;
        thread = new Thread(this, this.name);
        k = (pensioneer) ? ((long) (Math.random() * 1000) + 1000) : 1000;
        thread.start();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        Market.buyers.offer(this);
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(Thread.currentThread().getName() + " вошёл в магазин");
    }

    @Override
    public void chooseGoods() {
        try {
            for (int i = ((int) ((Math.random() * 4) + 1)); i > 0; i--) {
                thread.sleep((long) (k * ((Math.random() * 2) + 0.5)));
                System.out.println(Thread.currentThread().getName() + " выбрал товар");
                thread.sleep((long) (k * ((Math.random() * 1.2) + 0.1)));
                putGoodsToBucket();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goToOut() {
        System.out.println(Thread.currentThread().getName() + " покинул магазин");
    }

    @Override
    public void takeBucket() {
        try {
            thread.sleep((long) (k * ((Math.random() * 1.2) + 0.1)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " взял корзину");
    }

    @Override
    public void putGoodsToBucket() {
        bucket.add(Goods.values()[(int) (Math.random() * 9)]);
        System.out.println(Thread.currentThread().getName() + " положил " + bucket.get(bucket.size() - 1) + " в корзину");
    }
}
