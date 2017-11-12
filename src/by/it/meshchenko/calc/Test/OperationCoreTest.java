package by.it.meshchenko.calc.Test;

import by.it.meshchenko.calc.Parser;
import by.it.meshchenko.calc.Var;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationCoreTest {
    @Test
    public void add_FF() throws Exception {
        String strEx;
        Var var;
        strEx = "1+2";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("3.0", var.toString());
    }

    @Test
    public void add_VF() throws Exception {
        String strEx;
        Var var;
        strEx = "{1,2,3}+2";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{3.0,4.0,5.0}", var.toString());
    }

    @Test
    public void add_MF() throws Exception {
        String strEx;
        Var var;
        strEx = "{{1,2,3},{4,5,6},{7,8,9}}+2";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{3.0,4.0,5.0},{6.0,7.0,8.0},{9.0,10.0,11.0}}", var.toString());
    }

    @Test
    public void add_VV() throws Exception {
        String strEx;
        Var var;
        strEx = "{1,2,3}+{1,2,3}";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{2.0,4.0,6.0}", var.toString());
    }

    @Test
    public void add_MM() throws Exception {
        String strEx;
        Var var;
        strEx = "{{1,2,3},{4,5,6},{7,8,9}}+{{1,2,3},{4,5,6},{7,8,9}}";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{2.0,4.0,6.0},{8.0,10.0,12.0},{14.0,16.0,18.0}}", var.toString());
    }

    @Test
    public void div_FF() throws Exception {
        String strEx;
        Var var;
        strEx = "-4/(-1)";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("4.0", var.toString());
    }

    @Test
    public void div_VF() throws Exception {
        String strEx;
        Var var;
        strEx = "{1,2,3}/0.5";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{2.0,4.0,6.0}", var.toString());
    }

    @Test
    public void div_MF() throws Exception {
        String strEx;
        Var var;
        strEx = "{{1,2,3},{4,5,6},{7,8,9}}/(-1)";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{-1.0,-2.0,-3.0},{-4.0,-5.0,-6.0},{-7.0,-8.0,-9.0}}", var.toString());
    }

    @Test
    public void mul_FF() throws Exception {
        String strEx;
        Var var;
        strEx = "1.5*2";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("3.0", var.toString());
    }

    @Test
    public void mul_FV() throws Exception {
        String strEx;
        Var var;
        strEx = "-3*{1,2,3}";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{-3.0,-6.0,-9.0}", var.toString());
    }

    @Test
    public void mul_FM() throws Exception {
        String strEx;
        Var var;
        strEx = "-3*{{1,2,3},{4,5,6},{7,8,9}}";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{-3.0,-6.0,-9.0},{-12.0,-15.0,-18.0},{-21.0,-24.0,-27.0}}", var.toString());
    }

    @Test
    public void mul_VM() throws Exception {
        String strEx;
        Var var;
        strEx = "{1,2,3}*{{1,2,3},{4,5,6},{7,8,9}}";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{30.0,36.0,42.0}}", var.toString());
    }

    @Test
    public void mul_MV() throws Exception {
        String strEx;
        Var var;
        strEx = "{{1},{2},{3}}*{1,2,3}";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{1.0,2.0,3.0},{2.0,4.0,6.0},{3.0,6.0,9.0}}", var.toString());
    }

    @Test
    public void mul_MM() throws Exception {
        String strEx;
        Var var;
        strEx = "{{1,2,3},{4,5,6},{7,8,9}}*{{1,2,3},{4,5,6},{7,8,9}}";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{30.0,36.0,42.0},{66.0,81.0,96.0},{102.0,126.0,150.0}}", var.toString());
    }

    @Test
    public void sub_FF() throws Exception {
        String strEx;
        Var var;
        strEx = "9-7";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("2.0", var.toString());
    }

    @Test
    public void sub_VF() throws Exception {
        String strEx;
        Var var;
        strEx = "{1,2,3}-3";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{-2.0,-1.0,0.0}", var.toString());
    }

    @Test
    public void sub_MF() throws Exception {
        String strEx;
        Var var;
        strEx = "{{1,2,3},{4,5,6},{7,8,9}}-3";
        var = Parser.parseAndCalcEx(strEx).varValue;
        assertEquals("{{-2.0,-1.0,0.0},{1.0,2.0,3.0},{4.0,5.0,6.0}}", var.toString());
    }

}