package by.it.akhmelev.jd02_05.classwork;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {

        if (args.length>=2){
            String lang=args[0];
            String country=args[1];
            Locale locale=new Locale(lang,country);
            ResMan.INSTANCE.setLocale(locale);
        }

        System.out.println(ResMan.INSTANCE.getString(Msg.WELCOME));
        System.out.println(ResMan.INSTANCE.getString(Msg.HOW_DO_YOU_DO));
        System.out.println(ResMan.INSTANCE.getString(Msg.NAME));
        System.out.println(ResMan.INSTANCE.getString(Msg.TEST));


    }
}
