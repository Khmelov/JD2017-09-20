package by.it.meshchenko.project.java.controller;

import java.lang.reflect.Array;
import java.util.*;

public class Pages {

    public static final String css = "css";
    public static final String js = "js";

    public static final String index = "/index.jsp";
    public static final String home = "/lease.jsp";
    public static final String signin = "/signin.jsp";
    public static final String register = "/register.jsp";
    public static final String shoppingcenter = "/shoppingcenter.jsp";
    public static final String resetdb = "/resetdb.jsp";
    public static final String managerpage = "/managerpage.jsp";
    public static final String adminpage = "/adminpage.jsp";
    public static final String adm_rooms = "/adminpages/admrooms.jsp";
    public static final String adm_shoppingcenters = "/adminpages/admshoppingcenters.jsp";
    public static final String adm_addresses = "/adminpages/admaddresses.jsp";
    public static final String adm_cities = "/adminpages/admcities.jsp";
    public static final String adm_countries = "/adminpages/admcountries.jsp";
    public static final String adm_streets = "/adminpages/admstreets.jsp";
    public static final String adm_users = "/adminpages/admusers.jsp";
    public static final String manag_rooms = "/managrooms.jsp";

    public static final String cmdindex = "do?command=index";
    public static final String cmdsignin = "do?command=signin";
    public static final String cmdregister = "do?command=register";
    public static final String cmdlease = "do?command=lease";
    public static final String cmdshoppingcenter = "do?command=shoppingcenter";
    public static final String cmdsignout = "do?command=signout";
    public static final String cmdmanagerpage = "do?command=managerpage";
    public static final String cmdadminpage = "do?command=adminpage";
    public static final String cmdresetdb = "do?command=resetdb";
    public static final String cmdadmrooms = "do?command=admrooms";
    public static final String cmdadmshoppingcenters = "do?command=admshoppingcenters";
    public static final String cmdadmaddresses = "do?command=admaddresses";
    public static final String cmdadmcities = "do?command=admcities";
    public static final String cmdadmcountries = "do?command=admcountries";
    public static final String cmdadmstreets = "do?command=admstreets";
    public static final String cmdadmusers = "do?command=admusers";
    public static final String cmdmanagrooms = "do?command=managrooms";

    public final static List<String> RESURS = new ArrayList<String>(
            Arrays.asList(
                    css,
                    js
            )
    );

    public final static List<String> NOTAUTHENTICATION = new ArrayList<String>(
            Arrays.asList(
                    index,
                    cmdindex,
                    cmdsignin,
                    cmdregister,
                    cmdresetdb
            )
    );

    public final static List<String> AUTHENTICATION = new ArrayList<String>(
            Arrays.asList(
                    cmdlease,
                    cmdsignout,
                    cmdmanagerpage,
                    cmdadminpage,
                    cmdresetdb,
                    cmdshoppingcenter,
                    cmdadmrooms,
                    cmdadmshoppingcenters,
                    cmdadmaddresses,
                    cmdadmcities,
                    cmdadmcountries,
                    cmdadmstreets,
                    cmdadmusers,
                    cmdmanagrooms
            )
    );

    // Страницы, которые могут посещать пользователи с Role = 'user'
    public final static List<String> AUTHORIZATIONUser = new ArrayList<String>(
            Arrays.asList(
            )
    );
    // Страницы, которые могут посещать пользователи с Role = 'manager'
    public final static List<String> AUTHORIZATIONManager = new ArrayList<String>(
            Arrays.asList(
                    cmdmanagerpage,
                    cmdmanagrooms
            )
    );
    // Страницы, которые могут посещать пользователи с Role = 'admin'
    public final static List<String> AUTHORIZATIONAdmin = new ArrayList<String>(
            Arrays.asList(
                    cmdadminpage,
                    cmdadmrooms,
                    cmdadmshoppingcenters,
                    cmdadmaddresses,
                    cmdadmcities,
                    cmdadmcountries,
                    cmdadmstreets,
                    cmdadmusers
            )
    );
}
