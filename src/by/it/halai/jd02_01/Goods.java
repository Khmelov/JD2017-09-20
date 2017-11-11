package by.it.halai.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Vitaly Halai
 */
class Goods extends HashMap<String, Double> {

    static Goods items = new Goods();

    private List<String> names;

    private Goods() {
        this.put("Bread", 0.8);
        this.put("Milk", 1.5);
        this.put("Beer", 2.1);
        this.put("Snacks", 3.1);
        this.put("pizza", 10.6);
        names = new ArrayList<>(this.keySet());
    }

    String randomGood() {
        return names.get(Helper.random(0, names.size() - 1));
    }

}
