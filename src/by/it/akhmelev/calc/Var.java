package by.it.akhmelev.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements IOperation{

    static private Map<String, Var> mapvar=new HashMap<>();

    static void saveVar(String name, Var value){
        mapvar.put(name,value);
    }

    static Var getVar(String name){
        return mapvar.containsKey(name)?mapvar.get(name):null;
    }

    @Override
    public Var add(Var var) throws MathException {
        throw new MathException("Сложение невозможно");
    }

    @Override
    public Var sub(Var var) throws MathException {
        throw new MathException("Вычитание невозможно");
    }

    @Override
    public Var mul(Var var) throws MathException {
        throw new MathException("Умножение невозможно");
    }

    @Override
    public Var div(Var var) throws MathException {
        throw new MathException("Деление невозможно");
    }


}
