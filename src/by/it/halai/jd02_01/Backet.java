package by.it.halai.jd02_01;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Vitaly Halai
 */
public class Backet {
    List<String> backet = new ArrayList<>();

    public List addToBacket(String s) {
        backet.add(s);
        return backet;
    }

}
