package by.it.likhanau.jd02_01;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goods {
    static Map<String, Double> goods;
    static List<String> goodsName;

    static {
        goods = new HashMap<>();
        Goods.goods.put("Meat", 5.3);
        Goods.goods.put("Bread", 1.7);
        Goods.goods.put("Milk", 2.1);
        Goods.goods.put("Candies", 0.2);
        Goods.goods.put("Ice-cream", 3.0);
        Goods.goods.put("Vegetables", 1.4);
        Goods.goods.put("Fruits", 2.2);
        goodsName = new ArrayList<>(Goods.goods.keySet());
    }

    static String getRandomGood() {
        return goodsName.get(Util.generateRandomNumber(0, goodsName.size() - 1));
    }
}
