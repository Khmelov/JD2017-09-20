package by.it.mustaphin.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Pattern varsD = Pattern.compile(Patterns.exVal);
    Pattern varsV = Pattern.compile(Patterns.exVec);
    Pattern operation = Pattern.compile(Patterns.exOper);
    Pattern varNewName = Pattern.compile(Patterns.newName);
    Pattern varUsedName = Pattern.compile(Patterns.usedName);
    Pattern anyVar = Pattern.compile(Patterns.exAny);
    Pattern usedOrAny = Pattern.compile(Patterns.anyOrUsed);

    String newVarName = "";
    List<Var> varList = new ArrayList<>();

    void parseExpression(String line) {
        StoreData.storeToProp(line);
        Matcher matA = operation.matcher(line);
        Matcher matN = varNewName.matcher(line);
        Matcher uoa = usedOrAny.matcher(line);

        List<String[]> priority = new ArrayList<>();
        priority.add(new String[]{"="});
        priority.add(new String[]{"+", "-"});
        priority.add(new String[]{"*", "/"});

        while (uoa.find()) {
            Matcher usedName = varUsedName.matcher(uoa.group());
            Matcher anyV = anyVar.matcher(uoa.group());
            if (usedName.find()) {
                varList.add(getVar((String) StoreData.property.get(usedName.group())));
            }
            if (anyV.find()) {
                varList.add(getVar(anyV.group()));
            }
        }

        List<String> actions = new ArrayList<>();
        while (matA.find()) {
            actions.add(matA.group());
        }

        if (matN.find()) {
            newVarName = matN.group();
        }

        for (int i = actions.size() - 1; i >= 0; i--) {
            if (priority.get(0)[0].equals(actions.get(i)) || priority.get(0)[1].equals(actions.get(i))) {
                if (actions.get(i).equals("*")) {
                    varList.add(i, mul(varList.get(i), varList.get(i + 1)));
                }
                continue;
            } else if (priority.get(1)[0].equals(actions.get(i)) || priority.get(1)[1].equals(actions.get(i))) {

            } else if (priority.get(2)[0].equals(actions.get(i))) {

            }
        }

    }

    void doMathAct(String action) {
        if (action.equals("+")) {
            StoreData.data.put(newVarName, add(varList.get(0), varList.get(1)));
        }
        if (action.equals("-")) {
            StoreData.data.put(newVarName, sub(varList.get(0), varList.get(1)));
        }
        if (action.equals("*")) {
            StoreData.data.put(newVarName, mul(varList.get(0), varList.get(1)));
        }
        if (action.equals("/")) {
            StoreData.data.put(newVarName, div(varList.get(0), varList.get(1)));
        }
        StoreData.writeData();
        varList.clear();
    }

    boolean checkVarType(String value, Pattern pat) {
        return pat.matcher(value).matches();
    }

    Var getVar(String value) {
        if (checkVarType(value, varsD)) {
            return new VarD(value);
        } else if (checkVarType(value, varsV)) {
            return new VarV(value);
        }
        return Var.getVar(value);
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

    void read() {
        System.out.println("Напишите выражение или введите команду \"sortvar\" для отображения всех результатов или команду \"printvar\" или введите команду \"exit\" для выхода");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().trim();
        if (line.equalsIgnoreCase("sortvar")) {
//            StoreData.sortvar();
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
//            StoreData.writeData();
            System.exit(0);
        } else if (line.equalsIgnoreCase("printvar")) {
            StoreData.printvar();
            read();
        } else {
            parseExpression(line);
            read();
        }
    }
}
