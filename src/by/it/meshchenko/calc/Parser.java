package by.it.meshchenko.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    // Проверка на корректность операции присваивания (О.П.) ( A=2, A={1,2}, A={{1,2},{3,4}} )
    private static boolean isAssignVarValue(String str){
        boolean res = false;
        try {
            Pattern p = Pattern.compile(Patterns.exAssignNameVarValue);
            Matcher m = p.matcher(str);
            res = m.matches();
        }
        catch (Exception e){
        }
        return res;
    }

    // Проверка на корректность арифметического выражения (А.В.) ( {1,2}+{{1,2},{3,4}} )
    private static boolean isExFullCorrect(String str){
        boolean res = false;
        try {
            Pattern p = Pattern.compile(Patterns.exFull);
            Matcher m = p.matcher(str);
            res = m.matches();
        }
        catch (Exception e){

        }
        return res;
    }

    static Expression parseAssign(String str){
        Expression res = null;
        try{
            if(isAssignVarValue(str)){
                String[] strMass = str.split(Patterns.exAssign);
                res =  new Expression();
                res.setName(strMass[0]);
                res.setStrValue(strMass[1]);
                res.tempEx.putAll(parseEx(strMass[1]).tempEx);
            }
        }
        catch (Exception e){}
        return res;
    }

    public static Expression parseAndCalcAssign(String str) {
        Expression res = null;
        try{
            // Определяес в строке имя переменной и само выражение
            String[] strMass = str.split(Patterns.exAssign);
            if(strMass.length == 2) {
                res = new Expression();
                Pattern p = Pattern.compile(Patterns.nameVar);
                Matcher m = p.matcher(strMass[0]);
                if(m.matches()) {
                    res.setName(strMass[0]);
                    Expression.blockEx.put(Expression.majorKey + strMass[0], res);
                }
                else throw new CalcErrorException("Недопустимое имя переменной");
                res.setStrValue(strMass[1]);

                // парсим и вычисляем выражение
                parseEx(res);
            }
            else{
                throw new CalcErrorException("Неверное преобразование строкового выражения");
            }
        }
        catch (CalcErrorException e){
            e.printStackTrace();
        }
        return res;
    }

    public static Expression parseAndCalcEx(String str) {
        Expression res = new Expression();
        res.setStrValue(str);
        // парсим и вычисляем выражение
        parseEx(res);
        return res;
    }

    static Expression parseEx(String str){
        Expression res = null;
        if(isExFullCorrect(str)) {
            res = new Expression();
            StringBuilder strBuildVar = new StringBuilder(str);
            String strVar;
            Pattern p = Pattern.compile(Patterns.exAny);
            Pattern pOper = Pattern.compile(Patterns.exOper);

            Matcher m = p.matcher(strBuildVar);
            if(m.find()) {
                strVar = m.group();
                res.tempEx.put("var1", defineTypeVar(strVar));
                strBuildVar.delete(0, strVar.length());
            }

            Matcher mOper = pOper.matcher(strBuildVar);
            if(mOper.find()) {
                strVar = mOper.group();
                res.tempOp.add(strVar);
                strBuildVar.delete(0, strVar.length());
            }
            m = p.matcher(strBuildVar);
            if(m.find()) {
                strVar = m.group();
                res.tempEx.put("var2", defineTypeVar(strVar));
                strBuildVar.delete(0, strVar.length());
            }
        }
        return res;
    }

    private static void parseEx(Expression expr) {
        try {
            if (!expr.getStrValue().isEmpty()) {

                expr.varValue = doParseEx(expr);
            } else {
                throw new CalcErrorException("Пустое строковое выражение");
            }
        }
        catch (CalcErrorException e){
            e.printStackTrace();
        }
    }


    private static Var doParseEx(Expression expr){
        StringBuilder strBuild = new StringBuilder(expr.getStrValue());
        String key;
        String varStr;

        // Работа со скобками
        // Проверяем наличие скобок '( )' в выражении
        int br = isBrackets(expr.getStrValue(), 1);
        // Выражение содержит скобки '( )' и все скобки '() {} []' расставлены правильно
        if (br == 1) {
            do {
                // Делаем замену выражения в скабках на 'var1', 'var2' и т.д.
                // (4+5)*7-4*(3-1) --> var1*7-4*(3-1) --> var1*7-4*var2
                key = "var" + Expression.varNumber;
                varStr = replaceBracketsOnVar(strBuild, key);
                if (!varStr.isEmpty()) {
                    Expression.blockEx.put(key, new Expression(varStr));
                    Expression.varNumber++;
                }
            } while (!varStr.isEmpty());
        }
        // Продолжаем парсить строку по приоритетам операций и производить расчёт (рекурсивно)
        // В 'strBuild' обрабатываем приоритет операций '*/'
        // Продолжаем делать замены множителей на 'var..' на операции '*/'
        // var1*7-4*var2 --> var3-4*var2 --> var3-var4
        Pattern p = Pattern.compile(Patterns.exPriorOp1);
        Matcher m = p.matcher(strBuild);
        while(m.find()){
            key = "var" + Expression.varNumber;
            varStr = m.group();
            if(varStr.compareTo(strBuild.toString()) != 0) {
                Expression.blockEx.put(key, new Expression(varStr));
                strBuild.replace(strBuild.indexOf(varStr), strBuild.indexOf(varStr)+varStr.length(), key);
                m = p.matcher(strBuild);
                Expression.varNumber++;
            }
        }

        // Оставшуюся строку разбиваем на операнды
        String[] exCalc = strBuild.toString().split(Patterns.exOper);

        // Находим в строке знаки операций '+*-/'
        // Добавляем их в ArrayList<String> tempOp
        p = Pattern.compile(Patterns.exOper);
        m = p.matcher(strBuild);
        while(m.find()){
            expr.tempOp.add(m.group());
        }

        // Преобразуем элементы 'String[] exCalc' в Var и добавляем
        // их в LinkedHashMap<String, Var> tempEx для дальнейшего расчёта.
        // !И вот тут самое интересное! -  'defineTypeVar' вызывает 'doParseEx' (рекурсия)
        // если нам попадает элемент 'var..', это будет происходить до тех пор, пока
        // не посчитается выражение, которое не содержит 'var..'
        for(int i = 0; i < exCalc.length; i++){
            expr.tempEx.put("var" + i, defineTypeVar(exCalc[i]));
        }
        return Calc.calculate(expr);
    }

    // Соответствие строки паттерну переменной Var
    private static boolean isExVar(String str, String pattern){
        boolean res = false;
        //System.out.println(str);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        if(m.matches()){
            res = true;
        }
        return res;
    }

    // Если строка соответствует паттерну, return Var
    private static Var defineTypeVar(String str){
        Var res = null;
        try {
            if (isExVar(str, Patterns.exVal)) {
                res = new VarF(str);
            } else if (isExVar(str, Patterns.exVec)) {
                res = new VarV(str);
            } else if (isExVar(str, Patterns.exMat)) {
                res = new VarM(str);
            } else if (isExVar(str, Patterns.nameVar)) {
                Expression e1 = Expression.blockEx.get(str);
                if(e1 == null)
                    e1 = Expression.blockEx.get(Expression.majorKey + str);
                if (e1 == null)
                    throw new CalcErrorException("Отсутствует переменная в HashMap<String, Expression> blockEx");
                res = doParseEx(e1);
            } else {
                throw new CalcErrorException("Невозможно привести к типу Var");
            }
        }
        catch (CalcErrorException e){
            e.printStackTrace();
        }
        return res;
    }

    // Проверка на корректность скобок и есть ли в выражении определённые скобки
    // -1 - скобки расставлены не корректно
    // 0 - выражение не содержит указанных 'bracket' скобок, все остальные скобки
    //     расставлены правильно
    // 1 - выражение содержит скобки '( )' и все остальные скобки расставлены правильно
    // 2 - выражение содержит скобки '{ }' и все остальные скобки расставлены правильно
    // 3 - выражение содержит скобки '[ ]' и все остальные скобки расставлены правильно
    private static int isBrackets(String str, int bracket){
        int res = -1;
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            switch (str.charAt(i)){
                case '(': stack.push('('); break;
                case '{': stack.push('{'); break;
                case '[': stack.push('['); break;
                case ')':
                    if(!stack.isEmpty() && stack.pop().compareTo('(') == 0){
                        if(bracket == 1) flag = true;
                        break;
                    }
                    else{ return -1; }
                case '}':
                    if(!stack.isEmpty() && stack.pop().compareTo('{') == 0){
                        if(bracket == 2) flag = true;
                        break;
                    }
                    else{ return -1;}
                case ']':
                    if(!stack.isEmpty() && stack.pop().compareTo('[') == 0){
                        if(bracket == 3) flag = true;
                        break;
                    }
                    else{ return -1; }
                default: break;
            }
        }
        if(stack.isEmpty()) res = 0;
        if(flag) res = bracket;
        return res;
    }

    // Если выражение собержит скобки '(' ')', то возвращаем строку содержащую
    // в скобках при этом заменяя в исходной строке найденную строку на var1 и т.д.
    private static String replaceBracketsOnVar(StringBuilder strIn, String strRepl){
        String subStr = "";
        int position = 0;
        for(int i = 0; i < strIn.length(); i++){
            switch (strIn.charAt(i)){
                case '(': position = i; break;
                case ')':
                    subStr = strIn.substring(position+1, i);
                    strIn.replace(position, i+1, strRepl);
                    return subStr;
            }
        }
        return subStr;
    }

}
