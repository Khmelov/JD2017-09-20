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
        parser.parseExpression("A=44/55");
        parser.parseExpression("B=44-55");
        parser.parseExpression("C=44+55");
        parser.parseExpression("D=44*55");
    }
}
