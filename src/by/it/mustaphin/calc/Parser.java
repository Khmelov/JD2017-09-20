package by.it.mustaphin.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Pattern varsD = Pattern.compile(Patterns.exVal);
    Pattern varsV = Pattern.compile(Patterns.exVec);
    Pattern operation = Pattern.compile(Patterns.exOper);
    Pattern characters = Pattern.compile("[A-Z][0-9]?");
    Pattern anyVar = Pattern.compile(Patterns.exAny);

    String newVarName = "";
    List<Var> varList = new ArrayList<>();
    List<String> actions = new ArrayList<>();
    List<String> priority = new ArrayList<>(Arrays.asList("=", "-", "+", "/", "*"));

    void parseExpression(String line) {
        StoreData.writeToLog(line);
        String operands[] = line.split(Patterns.exOper);
        for (String operand : operands) {
            Matcher charMatcher = characters.matcher(operand);
            Matcher anyMatcher = anyVar.matcher(operand);
            if (charMatcher.find()) {
                if (charMatcher.group().equals(operands[0])) {
                    newVarName = charMatcher.group();
                    continue;
                }
                varList.add(getVar((String) StoreData.property.get(charMatcher.group())));
            } else if (anyMatcher.find()) {
                varList.add(getVar(anyMatcher.group()));
            }
        }
        Matcher matA = operation.matcher(line);
        while (matA.find()) {
            actions.add(matA.group());
        }

        doMathAct();
        varList.clear();
        actions.clear();
    }

    void doMathAct() {
        for (int i = actions.size() - 1; i >= 0; i--) {
            if (priority.get(3).equals(actions.get(i)) || priority.get(4).equals(actions.get(i))) {
                if (actions.get(i).equals("*")) {
                    varList.set(i - 1, mul(varList.get(i - 1), varList.get(i)));
                    varList.remove(i);
                    actions.remove(i);
                    if (varList.size() > 1) {
                        doMathAct();
                    }
                } else if (actions.get(i).equals("/")) {
                    varList.set(i - 1, div(varList.get(i - 1), varList.get(i)));
                    varList.remove(i);
                    actions.remove(i);
                    if (varList.size() > 1) {
                        doMathAct();
                    }
                }
            }
        }
        for (int i = actions.size() - 1; i >= 0; i--) {
            if (priority.get(2).equals(actions.get(i)) || priority.get(1).equals(actions.get(i))) {
                if (actions.get(i).equals("+")) {
                    varList.set(i - 1, add(varList.get(i - 1), varList.get(i)));
                    varList.remove(i);
                    actions.remove(i);
                    if (varList.size() > 1) {
                        doMathAct();
                    }
                } else if (actions.get(i).equals("-")) {
                    varList.set(i - 1, sub(varList.get(i - 1), varList.get(i)));
                    varList.remove(i);
                    actions.remove(i);
                    if (varList.size() > 1) {
                        doMathAct();
                    }
                }
            }
        }
        if (actions.size() == 1 && actions.get(0).equals("=")) {
//            for (Var v : varList) {
//                System.out.println(v);
//            }
//            System.out.println(varList.get(0));
//            StoreData.data.put(newVarName, varList.get(0));
//            StoreData.writeVar();
//            System.exit(0);
        }
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
            StoreData.writeVar();
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
//            StoreData.writeVar();
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
