package by.it.mustaphin.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
//        if (args.length >= 2) {
//            String lang = args[0];
//            String country = args[1];
//            Locale locale = new Locale(lang, country);
//            ResMan.INSTANCE.setLocale(locale);
//        }
//        System.out.println(ResMan.INSTANCE.getString(Msg.WELCOME));
//        System.out.println(ResMan.INSTANCE.getString(Msg.HOWDOYOUDO));
//        System.out.println(ResMan.INSTANCE.getString(Msg.NAME));
//
//        System.out.println(ResMan.INSTANCE.getDate());


        LangSwitcher switcher = new LangSwitcher();
        Locale locale = switcher.chooseLocale();
        ResMan.INSTANCE.setLocale(locale);
        System.out.println(ResMan.INSTANCE.getString(Msg.WELCOME));
        System.out.println(ResMan.INSTANCE.getString(Msg.HOWDOYOUDO));
        System.out.println(ResMan.INSTANCE.getString(Msg.NAME));
        System.out.println(ResMan.INSTANCE.getString(Msg.TEST));

        System.out.println(ResMan.INSTANCE.getDate());
    }
}
