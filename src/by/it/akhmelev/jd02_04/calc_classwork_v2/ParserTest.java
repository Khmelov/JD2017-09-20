package by.it.akhmelev.jd02_04.calc_classwork_v2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void calc() throws Exception {
        Parser parser=new Parser();
        String expression="A=2+6/3";
        String res=parser.calc(expression).toString();
        String control="4.0";
        assertTrue(res.equals(control));
    }

    @Test
    public void vector() throws Exception {
        Parser parser=new Parser();
        String expression="A={1,2}+{3,4}";
        String res=parser.calc(expression).toString();
        String control="{4.0,6.0}";
        assertEquals(res,control);
    }

}