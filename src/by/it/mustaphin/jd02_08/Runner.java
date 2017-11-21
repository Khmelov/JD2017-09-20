package by.it.mustaphin.jd02_08;

public class Runner {
    public static void main(String[] args) {
        DomParser dParser = new DomParser();
        dParser.toDo();
        System.out.println("===============================================================================");
        StAXParser stParser = new StAXParser();
        stParser.toDO();
    }
}
