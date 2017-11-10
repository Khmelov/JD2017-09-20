package by.it.akhmelev.calc;

public class ConsoleRunner {

    public static void main(String[] args) {
        Parser parser=new Parser();
        parser.calc("A=2+5.3+1-9*8-1/6");
//        B=A*3.5
//        B1=B+0.11*-5
//        B2=A/2-1

//        parser.calc("2+2");
//        parser.calc("2*2");
//        parser.calc("2/2");
//        parser.calc("2-2");
//        parser.calc("{1,2}+2");
//        parser.calc("{1,2}*2");
//        parser.calc("{1,2}/2");
//        parser.calc("{1,2}-2");
//
//        parser.calc("2+{1,2}");
//        parser.calc("2-{1,2}");
//        parser.calc("2*{1,2}");
//        parser.calc("2-{1,2}");
//
//        parser.calc("{{1,2},{3,4}}+6");
//        parser.calc("{{1,2},{3,4}}-6");
//        parser.calc("{{1,2},{3,4}}*6");
//        parser.calc("{{1,2},{3,4}}/6");
//
//        parser.calc("A=9");
//        parser.calc("B={3,5}");
    }
}
