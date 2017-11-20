package by.it.mustaphin.calc;

public class ConsoleRunner {
    public static void main(String[] args) {
//        Var varD1 = new VarD(4);
//        Var varD2 = new VarD(6);
//        varD1.assignment("scalAddScal", varD1.add(varD2));
//        varD1.assignment("scalDivScal", varD1.div(varD2));
//        varD1.assignment("scalMulScal", varD1.mul(varD2));
//        varD1.assignment("scalSubScal", varD1.sub(varD2));

//        new Parser().read(args[0]);
        Parser parser = new Parser();
        parser.parseExpression("A=2+5.3");
        parser.parseExpression("B=A*3.5");
        parser.parseExpression("B1=B+0.11*-5");
        parser.parseExpression("B2=A/2-1");
        parser.parseExpression("C=B+(A*2)");
        parser.parseExpression("D=((C-0.15)-20)/(7-5)");
        parser.parseExpression("E={2,3}*(D/2)");
    }
}
