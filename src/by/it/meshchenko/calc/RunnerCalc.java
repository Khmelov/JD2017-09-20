package by.it.meshchenko.calc;

import by.it.malyshev.jd01_03.InOut;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RunnerCalc {

    private static void printOneVar(String str, Var v) throws IOException{
        if (v!=null){
            System.out.println(str + " = " + v);
            InOutFile.log(str + " = " + v.toString());
        }
    }

    public static void main(String[ ] args)  throws IOException {




        // Выражения для тестирования операций чтения и записи файла
        Expression ex1 = Parser.parseAssign("C=-9.5");
        Expression ex2 = Parser.parseAssign("A={1,2,3}");
        Expression ex3 = Parser.parseAssign("Z=0.5");
        Expression ex4 = Parser.parseAssign("B=-18.1");
        Expression ex5 = Parser.parseAssign("D={{1,2,3},{4,5,6},{7,8,9}}");
        LinkedHashMap<String, String> hs = new LinkedHashMap<String, String>() {
            {
                this.put(ex1.getName(), ex1.getStrValue());
                this.put(ex2.getName(), ex2.getStrValue());
                this.put(ex3.getName(), ex3.getStrValue());
                this.put(ex4.getName(), ex4.getStrValue());
                this.put(ex5.getName(), ex5.getStrValue());
            }
        };
        //Проверка работы записи файла
        InOutFile.write(hs);
        //Проверка работы чтения файла
        LinkedHashMap<String, String> hsF = InOutFile.read();
        if(hsF != null && hsF.size() > 0){
            System.out.println("printVar from File");
            Calc.printStringVar(hsF);
            System.out.println("sortVar from File");
            Calc.sortStringVar(hsF);
        }
        else {
            System.out.println("printVar");
            Calc.printStringVar(hs);
            System.out.println("sortVar");
            Calc.sortStringVar(hs);
        }


        //Переменные для тестирования операций +*-/
        String vec = "{1,2,3}";
        String matrix = "{{1,2,3},{4,5,6},{7,8,9}}";

        //Проверка операций +*-/ с переменными Var
        // F F
        String opStr = "проверка +-*/ операций со скалярами";
        String strEx1 = "1+2";
        String strEx2 = "9-7";
        String strEx3 = "1.5*2";
        String strEx4 = "-4/(-1)";
        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // V F
        opStr = "проверка  +-*/ операций с векторами справа и скалярами слева";
        strEx1 = "{1,2,3}+2";
        strEx2 = "{-1,2,3}-7";
        strEx3 = "{1,2,3}*2";
        strEx4 = "{1,2,3}/0";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // F V
        opStr = "проверка  +-*/ операций со скалярами справа и векторами слева";
        strEx1 = "1+{1,2,3}";
        strEx2 = "2-{1,2,3}";
        strEx3 = "1*{1,2,3}";
        strEx4 = "2/{1,2,3}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // V V
        opStr = "проверка  +-*/ операций с двумя векторами";
        strEx1 = "{1,2,3}+{1,2,3}";
        strEx2 = "{1,2,3}-{1,2,3}";
        strEx3 = "{1,2,3}*{1,2,3}";
        strEx4 = "{1,2,3}/{1,2,3}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // M F
        opStr = "проверка  +-*/ операций с матрицей справа и скалярами слева";
        strEx1 = "{{1,2,3},{4,5,6},{7,8,9}}+2";
        strEx2 = "{{1,2,3},{4,5,6},{7,8,9}}-7";
        strEx3 = "{{1,2,3},{4,5,6},{7,8,9}}*2";
        strEx4 = "{{1,2,3},{4,5,6},{7,8,9}}/(-1)";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // F M
        opStr = "проверка  +-*/ операций со скалярами справа и матрицей слева";
        strEx1 = "1+{{1,2,3},{4,5,6},{7,8,9}}";
        strEx2 = "9-{{1,2,3},{4,5,6},{7,8,9}}";
        strEx3 = "1.5*{{1,2,3},{4,5,6},{7,8,9}}";
        strEx4 = "-4/{{1,2,3},{4,5,6},{7,8,9}}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // M V
        opStr = "проверка  +-*/ операций с матрицей справа и вектором слева";
        strEx1 = "{{1,2,3},{4,5,6},{7,8,9}}+{1,2,3}";
        strEx2 = "{{1,2,3},{4,5,6},{7,8,9}}-{1,2,3}";
        strEx3 = "{{1,2,3},{4,5,6},{7,8,9}}*{1,2,3}";
        strEx4 = "{{1,2,3},{4,5,6},{7,8,9}}/{1,2,3}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // V M
        opStr = "проверка  +-*/ операций с вектором справа и матрицей слева";
        strEx1 = "{1,2,3}+{{1,2,3},{4,5,6},{7,8,9}}";
        strEx2 = "{1,2,3}-{{1,2,3},{4,5,6},{7,8,9}}";
        strEx3 = "{1,2,3}*{{1,2,3},{4,5,6},{7,8,9}}";
        strEx4 = "{1,2,3}/{{1,2,3},{4,5,6},{7,8,9}}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        // M M
        opStr = "проверка  +-*/ операций с двумя матрицами";
        strEx1 = "{{1,2,3},{4,5,6},{7,8,9}}+{{1,2,3},{4,5,6},{7,8,9}}";
        strEx2 = "{{1,2,3},{4,5,6},{7,8,9}}-{{1,2,3},{4,5,6},{7,8,9}}";
        strEx3 = "{{1,2,3},{4,5,6},{7,8,9}}*{{1,2,3},{4,5,6},{7,8,9}}";
        strEx4 = "{{1,2,3},{4,5,6},{7,8,9}}/{{1,2,3},{4,5,6},{7,8,9}}";

        InOutFile.log(opStr);
        System.out.println();
        System.out.println(opStr);
        printOneVar(strEx1, Parser.parseAndCalcEx(strEx1).varValue);
        printOneVar(strEx2, Parser.parseAndCalcEx(strEx2).varValue);
        printOneVar(strEx3, Parser.parseAndCalcEx(strEx3).varValue);
        printOneVar(strEx4, Parser.parseAndCalcEx(strEx4).varValue);

        //Очистка буффера
        Expression.clearBuffer();

        // Тестирование задания из jd02_04
        // A=2+5.3 (выведетна экран 7.3)
        strEx1 = "A=2+5.3";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);

        // B=A*3.5 (выведетна экран 25.55)
        strEx1 = "B=A*3.5";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);

        // B1=B+0.11*-5 (выведетна экран 25)
        strEx1 = "B1=B+0.11*(-5)";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);

        // B2=A/2-1 (выведет на экран 2.65)
        strEx1 = "B2=A/2-1";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);

        // C=B+(A*2)(выведет на экран 40.15).
        strEx1 = "C=B+(A*2)";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);

        // D=((C-0.15)-20)/(7-5) (выведет на экран 10)
        strEx1 = "D=((C-0.15)-20)/(7-5)";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);

        // E={2,3}*(D/2) (выведет на экран {10,15} ).
        strEx1 = "E={2,3}*(D/2)";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);

        // F={{1,2,3},{4,5,6},{7,8,9}}*(10+5)*(-1*(-4))-(2+1-3*(12-9))
        strEx1 = "F={{1,2,3},{4,5,6},{7,8,9}}*(10+5)*(-1*(-4))-(2+1-3*(12-9))";
        printOneVar(strEx1, Parser.parseAndCalcAssign(strEx1).varValue);
    }
}
