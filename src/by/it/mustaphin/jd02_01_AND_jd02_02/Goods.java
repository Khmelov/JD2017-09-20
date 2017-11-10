package by.it.mustaphin.jd02_01_AND_jd02_02;

public enum Goods {
    MEAT, OIL, MILK, TEA, NUTS, SNACK, CHOCOLATE, ONION, CHEESE;

    int getPrice() {
        switch (this) {
            case MEAT:
                return 10;
            case OIL:
                return 7;
            case MILK:
                return 5;
            case TEA:
                return 2;
            case NUTS:
                return 1;
            case SNACK:
                return 2;
            case CHOCOLATE:
                return 3;
            case ONION:
                return 4;
            case CHEESE:
                return 6;
            default:
                return 0;
        }
    }
}
