package by.it.akhmelev.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    List<String> operadns;
    List<String> operations;
    final List<String> prior = new ArrayList<>(Arrays.asList(
            new String[]{"=", "+", "-", "*", "/"})
    );

    //проверка типа вынесена в метод
    private static boolean checkPattern(String pattern, String str) {
        return Pattern.compile(pattern).matcher(str).matches();
    }


    //преобразование строки в переменную
    private static Var getVar(String strVar) throws MathException {
        if (checkPattern(Patterns.exMat, strVar))
            throw new MathException("Работа с матрицами пока не реализована.");
        if (checkPattern(Patterns.exVec, strVar))
            return new VarV(strVar);
        if (checkPattern(Patterns.exVal, strVar))
            return new VarD(strVar);
        return Var.getVar(strVar);
    }

    private int getPositionOperation() {
        int currentPrior = -1;
        int currentPosition = -1;
        for (int i = 0; i < operations.size(); i++) {
            String currentOperation = operations.get(i);
            if (currentPrior < prior.indexOf(currentOperation)) {
                currentPosition = i;
                currentPrior = prior.indexOf(currentOperation);
            }
        }
        return currentPosition;
    }

    void debug() {
        for (int i = 0; i < operations.size(); i++) {
            System.out.print(operadns.get(i));
            System.out.print(operations.get(i));
        }
        System.out.print(operadns.get(operations.size()));
        System.out.println();
    }


    //разбор выражения
    Var calc(String expr) {
        Var result=null;
        try {
            operadns = new ArrayList<>(Arrays.asList(expr.split(Patterns.exOper)));
            Matcher m = Pattern.compile(Patterns.exOper).matcher(expr);
            operations = new ArrayList<>();
            while (m.find())
                operations.add(m.group());
            while (operations.size() > 0) {
                int currentPosition = getPositionOperation();
                String strOne = operadns.get(currentPosition);
                String strTwo = operadns.remove(currentPosition + 1);
                String operation = operations.remove(currentPosition);
                Var one = getVar(strOne);
                Var two = getVar(strTwo);
                if (operation.equals("=")) {
                    Var.saveVar(strOne, two);
                } else {
                    switch (operation) {
                        case "+":
                            result = one.add(two);
                            break;
                        case "-":
                            result = one.sub(two);
                            break;
                        case "*":
                            result = one.mul(two);
                            break;
                        case "/":
                            result = one.div(two);
                            break;
                    }
                    operadns.set(currentPosition, result.toString());
                    debug();
                }
            }
        } catch (MathException e) {
            System.out.flush();
            System.out.println(expr + " " + e.getMessage());
        }
        return result;
    }
}
