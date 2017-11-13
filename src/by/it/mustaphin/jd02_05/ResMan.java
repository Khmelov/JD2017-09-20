package by.it.mustaphin.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private ResourceBundle bundle;
    private String path = "by.it.mustaphin.jd02_05.res.messages";
    private DateFormat dateFormat;

    ResMan() {
        bundle = ResourceBundle.getBundle(path, Locale.getDefault());
        dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
    }

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(path, locale);
        dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
    }

    String getString(String key) {
        return bundle.getString(key);
    }

    String getDate() {
        return dateFormat.format(new Date());
    }
}
