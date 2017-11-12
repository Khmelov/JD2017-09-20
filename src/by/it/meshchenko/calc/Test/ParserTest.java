package by.it.meshchenko.calc.Test;

import by.it.meshchenko.calc.Parser;
import by.it.meshchenko.calc.Var;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void parseAndCalcAssign() throws Exception {
        String strEx1 = "A=2+5.3";
        Var var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("7.3", var.toString());
        // B=A*3.5 (выведетна экран 25.55)
        strEx1 = "B=A*3.5";
        var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("25.55", var.toString());
        // B1=B+0.11*-5 (выведетна экран 25)
        strEx1 = "B1=B+0.11*(-5)";
        var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("25.0", var.toString());
        // B2=A/2-1 (выведет на экран 2.65)
        strEx1 = "B2=A/2-1";
        var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("2.65", var.toString());
        // C=B+(A*2)(выведет на экран 40.15).
        strEx1 = "C=B+(A*2)";
        var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("40.15", var.toString());
        // D=((C-0.15)-20)/(7-5) (выведет на экран 10)
        strEx1 = "D=((C-0.15)-20)/(7-5)";
        var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("10.0", var.toString());
        // E={2,3}*(D/2) (выведет на экран {10,15} ).
        strEx1 = "E={2,3}*(D/2)";
        var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("{10.0,15.0}", var.toString());
        // F={{1,2,3},{4,5,6},{7,8,9}}*(10+5)*(-1*(-4))-(2+1-3*(12-9)) (выведет на экран {{66.0,126.0,186.0},{246.0,306.0,366.0},{426.0,486.0,546.0}} )
        strEx1 = "F={{1,2,3},{4,5,6},{7,8,9}}*(10+5)*(-1*(-4))-(2+1-3*(12-9))";
        var = Parser.parseAndCalcAssign(strEx1).varValue;
        assertEquals("{{66.0,126.0,186.0},{246.0,306.0,366.0},{426.0,486.0,546.0}}", var.toString());
    }
}