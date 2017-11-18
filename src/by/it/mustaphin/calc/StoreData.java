package by.it.mustaphin.calc;

import java.io.*;
import java.util.*;

public class StoreData {

    static HashMap<String, Var> data = new HashMap<>();
    static Properties property = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/by/it/mustaphin/calc/vars.txt")) {
            property.load(fis);
            Enumeration en = property.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                data.put(key, Var.getVar((String) property.get(key)));
            }
        } catch (FileNotFoundException | ClassCastException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeToLog(String line){
        try (FileWriter out = new FileWriter(new File(System.getProperty("user.dir") + "/src/by/it/mustaphin/calc/log.txt"), true)) {
            out.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeVar() {
        try (FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/by/it/mustaphin/calc/vars.txt")) {
            Map<String, String> dataValueToStr = new HashMap<>();
            for (Map.Entry<String, Var> me : data.entrySet()) {
                dataValueToStr.put(me.getKey(), me.getValue().toString());
            }
            property.putAll(dataValueToStr);
            property.store(fos, null);
        } catch (FileNotFoundException | ClassCastException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void sortvar() {
        SortedMap<String, Var> dataSorted = new TreeMap(data);
        Set<Map.Entry<String, Var>> dataSet = dataSorted.entrySet();
        Iterator<Map.Entry<String, Var>> itData = dataSet.iterator();
        while (itData.hasNext()) {
            Map.Entry<String, Var> me = itData.next();
            System.out.printf("%-11s = %s\n", me.getKey(), (null == me.getValue()) ? "Выполнить операцию невозможно либо операция не реализована" : me.getValue());
        }
    }

    static public void printvar() {
        for (Map.Entry<String, Var> couple : data.entrySet()) {
            System.out.printf("%-11s\n", couple.getKey());
        }
    }
}
