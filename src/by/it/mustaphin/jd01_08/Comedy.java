package by.it.mustaphin.jd01_08;

public class Comedy extends BelarussianMovie {

    private int carRentCost = 400;
    private int studioRentCost = 1000;
    private int equipmentRentCost = 500;
    private String[] actors = {"Bulka", "Galigyn"};
    private int bulkaHonorarium = 100;
    private int galigynHonorarium = 150;
    private int createEditing = 60;
    private int prepareProduction = 100;
    private int actionDays = 20;
    private String director = "Michael Finberg";
    private boolean rentalTypeBR = true;
    private boolean rentalTypeTV = false;
    private boolean rentalTypeTH = super.rentalTypeFR;
    private boolean rentalTypeFR = super.rentalTypeFR;

    public Comedy() {
        System.out.println("(В теле метода) Создание фильма");
        this.desc = "Belorussian comedy film";
        this.duration = 90;
        this.imdb = 1.2;
        this.year = 2017;
        this.name = "Дожинки";
    }

    @Override
    public int calcBudget() {
        System.out.println("(В теле метода) Подсчёт затрат " + carRentCost + studioRentCost + equipmentRentCost + bulkaHonorarium + galigynHonorarium);
        return carRentCost + studioRentCost + equipmentRentCost + bulkaHonorarium + galigynHonorarium;
    }

    @Override
    public String[] invitedActors() {
        System.out.println("(В теле метода) Приглашённые актёры " + actors[0] + " " + actors[1]);
        return actors;
    }

    @Override
    public int timeWork() {
        System.out.println("(В теле метода) Срок съёмки " + createEditing + prepareProduction + actionDays);
        return createEditing + prepareProduction + actionDays;
    }

    @Override
    public int honoraryTotal() {
        System.out.println("(В теле метода) Затраты на гонорары " + bulkaHonorarium + galigynHonorarium);
        return bulkaHonorarium + galigynHonorarium;
    }

    @Override
    public String director() {
        System.out.println("(В теле метода) Режиссёр " + director);
        return director;
    }

    @Override
    public boolean blueray() {
        System.out.println("(В теле метода) Издано на Blue-Ray " + rentalTypeBR);
        return this.rentalTypeBR;
    }

    @Override
    public boolean cinema() {
        System.out.println("(В теле метода) Показ в кинотеатрах " + rentalTypeTH);
        return this.rentalTypeTH;
    }

    @Override
    public boolean cabelChannel() {
        System.out.println("(В теле метода) Показ по кабельному телевидению " + rentalTypeTV);
        return this.rentalTypeTV;
    }

    @Override
    public boolean free() {
        System.out.println("(В теле метода) Доступно на youtube " + rentalTypeFR);
        return this.rentalTypeFR;
    }

    @Override
    public String country() {
        System.out.println("(В теле метода) Снято в Беларуси");
        return "BLR";
    }

    @Override
    public String getRights() {
        System.out.println("(В теле метода) Соблюдение прав Reserved");
        return "Reserved";
    }

    @Override
    public String toString() {
        return String.format("%s\nОписание: %s\nСтрана производства: %s\nПрава: %s\nВ ролях: %s а так же %s\n", super.toString(), desc, country(), getRights(), actors[0], actors[1]);
    }
}
