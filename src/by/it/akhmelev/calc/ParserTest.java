package by.it.akhmelev.calc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 10.11.2017.
 */
public class ParserTest {
    @Test
    public void calc() throws Exception {
        Parser p=new Parser();
        String res=p.calc("4+4").toString();
        assertEquals("8.0",res);
    }

}