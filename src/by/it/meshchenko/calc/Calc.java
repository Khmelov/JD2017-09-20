package by.it.meshchenko.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    public static void printVar(Map<String, Var> map){
        Iterator<Map.Entry<String, Var>> itM = map.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<String, Var> temp = itM.next();
            System.out.printf("%-8s %-20s %n", temp.getKey(),temp.getValue().toString());
        }
    }
    public static void sortVar(Map<String, Var> map){
        LinkedHashMap<String, Var> l = new LinkedHashMap<>();
        l.putAll(sortByKey(map));
        Iterator<Map.Entry<String, Var>> itM = l.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<String, Var> temp = itM.next();
            System.out.printf("%-8s %-20s %n", temp.getKey(),temp.getValue().toString());
        }
    }

    public static void printStringVar(Map<String, String> map){
        Iterator<Map.Entry<String, String>> itM = map.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<String, String> temp = itM.next();
            System.out.printf("%-8s %-20s %n", temp.getKey(),temp.getValue());
        }
    }
    public static void sortStringVar(Map<String, String> map){
        LinkedHashMap<String, String> l = new LinkedHashMap<>();
        l.putAll(sortByKey(map));

        Iterator<Map.Entry<String, String>> itM = l.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<String, String> temp = itM.next();
            System.out.printf("%-8s %-20s %n", temp.getKey(),temp.getValue());
        }
    }

    public static Var calculate(Expression expres){
        Var res = null;
        Iterator<Map.Entry<String, Var>> itM = expres.tempEx.entrySet().iterator();
        int i = -1;
        while (itM.hasNext()){

            Map.Entry<String, Var> temp = itM.next();
            if(res == null){
                res = temp.getValue();
            }
            else {
                if(expres.tempOp.size() > 0){
                    if(expres.tempOp.get(i).compareTo("+") == 0){
                        res = res.add(temp.getValue());
                    }
                    else if(expres.tempOp.get(i).compareTo("/") == 0){
                        res = res.div(temp.getValue());
                    }
                    else if(expres.tempOp.get(i).compareTo("*") == 0){
                        res = res.mul(temp.getValue());
                    }
                    else if(expres.tempOp.get(i).compareTo("-") == 0){
                        res = res.sub(temp.getValue());
                    }
                    else{}
                }
//                else {
//                    res = res.add(temp.getValue());
//                }
            }
            i++;
        }


        return res;
    }

    public static <K extends Comparable<? super K>, V > Map<K, V> sortByKey(Map<K, V> map )
    {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                return (o1.getKey()).compareTo( o2.getKey() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
