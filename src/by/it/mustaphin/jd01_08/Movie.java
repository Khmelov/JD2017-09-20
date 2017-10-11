package by.it.mustaphin.jd01_08;

public abstract class Movie implements Productable {

    protected String name;

    protected int year;

    protected int duration;//minutes

    protected double imdb;

    protected String desc;

    @Override
    public String toString() {
        return String.format("Название: %s\nгод: %-4d\nрейтинг: %-2.2g\nпродолжительность: %-3d минут\n", name, year, imdb, duration);
    }
}
