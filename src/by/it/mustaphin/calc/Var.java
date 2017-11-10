package by.it.mustaphin.calc;

abstract class Var implements MathOperations, Variable {

    @Override
    public Var add(Var var) {
        try {
            throw new MathException(this + " Сложение не возможно " + var);
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Var sub(Var var) {
        try {
            throw new MathException(this + " Вычитние не возможно " + var);
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Var mul(Var var) {
        try {
            throw new MathException(this + " Умножение не возможно " + var);
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Var div(Var var) {
        try {
            throw new MathException(this + " Деление не возможно " + var);
        } catch (MathException e) {
            e.printStackTrace();
        }
        return null;
    }

    static Var getVar(String str) {
        if (str.contains("{{")) {
            return new VarM(str);
        } else if (str.contains("{")) {
            return new VarV(str);
        } else {
            return new VarD(str);
        }
    }

}
