package by.it.mustaphin.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private ResourceBundle bundle;
    private String path = "by.it.mustaphin.jd02_05.res.messages";

    ResMan() {
        bundle = ResourceBundle.getBundle(path, Locale.getDefault());
    }

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(path, locale);
    }

    String getString(String key) {
        return bundle.getString(key);
    }
}
