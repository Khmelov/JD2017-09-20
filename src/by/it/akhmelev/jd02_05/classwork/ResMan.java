package by.it.akhmelev.jd02_05.classwork;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {
    INSTANCE;
    private ResourceBundle bundle;
    private String Path="by.it.akhmelev.jd02_05.classwork.res.messages";
    ResMan() {
        Locale.setDefault(Locale.ENGLISH);
        bundle = ResourceBundle.getBundle(Path,Locale.CANADA);
    }
    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(Path,locale);
    }
    String getString(String key){
        return bundle.getString(key);
    }

}
