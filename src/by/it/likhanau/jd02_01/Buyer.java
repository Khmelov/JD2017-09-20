package by.it.likhanau.jd02_01;


class Buyer implements IBuyer, Runnable {
    private int number;

    Buyer(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Buyer # " + number + '.';
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " has entered the shop.");
    }

    @Override
    public void chooseGoods() {
        Util.generateRandomNumber(500, 2_000);
        System.out.println(this + " is choosing goods.");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " has left the shop.");
    }


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();

    }
}
