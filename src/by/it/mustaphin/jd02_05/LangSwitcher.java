package by.it.mustaphin.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class LangSwitcher {
    Scanner sc;

    public LangSwitcher() {
        this.sc = new Scanner(System.in);
    }

    Locale chooseLocale() {
        System.out.println("Укажите локаль. Допускаются только значения: \"en\", \"ru\", \"be\"");
        String locLine = sc.nextLine();
        switch (locLine) {
            case "en":
                return Locale.US;
            case "ru":
                return new Locale("ru", "RU");
            case "be":
                return new Locale("be", "BY");
            default:
                chooseLocale();
                break;
        }
        return Locale.getDefault();
    }
}
