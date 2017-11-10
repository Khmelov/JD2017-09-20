package by.it.mustaphin.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    void read() {
        System.out.println("Напишите выражение или введите команду \"sortvar\" для отображения всех результатов или команду \"printvar\" или введите команду \"exit\" для выхода");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().trim();
        if (line.equalsIgnoreCase("sortvar")) {
            StoreData.sortvar();
            read();
        } else if (line.equalsIgnoreCase("exit")) {
            StoreData.writeData();
            System.exit(0);
        } else if (line.equalsIgnoreCase("printvar")) {
            StoreData.printvar();
            read();
        } else {
            parseExpression(line);
            read();
        }
    }

    void read(String line) {
        if (line.equalsIgnoreCase("sortvar")) {
            StoreData.sortvar();
            read();
        } else if (line.equalsIgnoreCase("exit")) {
            StoreData.writeData();
            System.exit(0);
        } else if (line.equalsIgnoreCase("printvar")) {
            StoreData.printvar();
            read();
        } else {
            parseExpression(line);
            read();
        }
    }

    void parseExpression(String line) {
        try (FileWriter out = new FileWriter(new File(System.getProperty("user.dir") + "/src/by/it/mustaphin/calc/log.txt"), true)) {
            out.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern action = Pattern.compile("[-+*/]");
        Pattern varsD = Pattern.compile("[^-{},*+/=][0-9.]+|[0-9.]+");
        Pattern varsV = Pattern.compile("[{][0-9.,]+[}]");
        Pattern varName = Pattern.compile("[a-zA-Z]+");
        Matcher matD = varsD.matcher(line);
        Matcher matV = varsV.matcher(line);
        List<Var> varList = new ArrayList<>();
        while (matV.find()) {
            varList.add(new VarV(matV.group()));
        }
        while (matD.find()) {
            varList.add(new VarD(matD.group()));
        }
        Matcher matA = action.matcher(line);
        Matcher matN = varName.matcher(line);
        while (matA.find() & matN.find()) {
            if (matA.group().equals("+")) {
                StoreData.data.put(matN.group(), add(varList.get(0), varList.get(1)));
            }
            if (matA.group().equals("-")) {
                StoreData.data.put(matN.group(), sub(varList.get(0), varList.get(1)));
            }
            if (matA.group().equals("*")) {
                StoreData.data.put(matN.group(), mul(varList.get(0), varList.get(1)));
            }
            if (matA.group().equals("/")) {
                StoreData.data.put(matN.group(), div(varList.get(0), varList.get(1)));
            }
        }
        varList.clear();
    }

    <T extends Var> Var add(T var1, T var2) {
        return var1.add(var2);
    }

    <T extends Var> Var sub(T var1, T var2) {
        return var1.sub(var2);
    }

    <T extends Var> Var mul(T var1, T var2) {
        return var1.mul(var2);
    }

    <T extends Var> Var div(T var1, T var2) {
        return var1.div(var2);
    }

}
