package by.it.mustaphin.jd01_08;

public abstract class AdultOnly extends Movie implements Productable {

    public final int AGE_RESTRICTION = 18;

    public AdultOnly() {
        imdb = 0.0;
        desc = "";
    }

    @Override
    public int calcBudget() {
        return 0;
    }

    @Override
    public String[] invitedActors() {
        return null;
    }

    @Override
    public int timeWork() {
        return 1;
    }

    @Override
    public int honoraryTotal() {
        return 0;
    }

    @Override
    public String country() {
        return "Germany";
    }

    @Override
    public String getRights() {
        return "copy rights reserved";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
