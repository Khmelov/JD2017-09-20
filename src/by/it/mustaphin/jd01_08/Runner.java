package by.it.mustaphin.jd01_08;

public class Runner {

    public static void main(String[] args) {
        Movie film1 = new Comedy();
        System.out.println(film1);
        film1.country();
        ISale product = new Comedy();
        System.out.printf("\nПоказ по кабельному телевидению %s\nПоказ в кинотеатрах%s\nВыход на Blue-Ray%s\nДоступен на youtube %s", product.cabelChannel(), product.cinema(), product.blueray(), product.free());
        Productable item = new Comedy();

//        int calcBudget();//dollars
//
//        String[] invitedActors();
//
//        int timeWork();//days
//
//        int honoraryTotal();//dollars
//
//        String country();
//
//        String getRights();
//
//        String director();

        System.out.printf("\nБюджет картины %s$\nСтрана производства %s\nРежиссёр %s\nСоблюдение прав %s\nГонорары звёздам %s$\nВ ролях %s\nа так же %s\nСрок съёмок %s дней\n", item.calcBudget(), item.country(), item.director(), item.getRights(), item.honoraryTotal(), item.invitedActors()[0], item.invitedActors()[1], item.timeWork());
    }

}
