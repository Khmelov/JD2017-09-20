package by.it.meshchenko.calc;

import java.util.*;

public class Expression {
    private String name;
    private String strValue;

    public static final String majorKey = "1_majorKey_";
    public static int varNumber;
    public static HashMap<String, Expression> blockEx;

    public LinkedHashMap<String, Var> tempEx;
    public ArrayList<String> tempOp;
    public Var varValue;

    static {
        blockEx = new HashMap<>();
        varNumber = 0;
    }
    public Expression() {
        this.tempEx = new LinkedHashMap<>();
        this.tempOp = new ArrayList<>();
    }
    public Expression(String strValue) {
        this();
        this.strValue = strValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    static void clearBuffer(){
        blockEx = new HashMap<>();
        varNumber = 0;
    }

}
