package by.it.mustaphin.jd01_08;

public abstract class BelarussianMovie extends Movie implements ISale {

    protected boolean rentalTypeBR = false;
    protected boolean rentalTypeTV = false;
    protected boolean rentalTypeTH = true;
    protected boolean rentalTypeFR = true;

    @Override
    public String country() {
        System.out.println("(В теле метода) азвание страны: съёмки ведутся в РБ");
        return "Belarus";
    }

    @Override
    public String getRights() {
        System.out.println("(В теле метода) Соблюдение прав: не указано");
        return "Unsigned";
    }

    @Override
    public String toString() {
        return String.format("%s\nСтрана производства: %s\nПрава: %s\n", super.toString(), country(), getRights());
    }
}
