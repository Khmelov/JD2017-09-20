package by.it.mustaphin.calc;

public class VarD extends Var {

    private double value = 0;

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public void fromString(String str) {
        value = Double.parseDouble(str);
    }

    VarD(double value) {
        super();
        this.value = value;
    }

    VarD(String valStr) {
        fromString(valStr);
    }

    @Override
    public Var add(Var var) {
//        System.out.println("дискретного числа с числом\n");
        if (var instanceof VarD)
            return new VarD(this.value + ((VarD) var).value);
        else
            return var.add(this);
    }

    @Override
    public Var sub(Var var) {
//        System.out.println("дискретного числа из числа\n");
        if (var instanceof VarD)
            return new VarD(this.value - ((VarD) var).value);
        else return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
//        System.out.println("дискретного числа на число\n");
        if (var instanceof VarD) {
            return new VarD(this.value * ((VarD) var).value);
        } else return var.mul(this);
    }

    @Override
    public Var div(Var var) {
//        System.out.println("дискретного числа на число\n");
        if (var instanceof VarD) {
            if (((VarD) var).value == 0) {
                try {
                    throw new MathException("Деленеие на 0");
                } catch (MathException e) {
                    e.printStackTrace();
                }
            }
            return new VarD(this.value / ((VarD) var).value);
        } else return super.div(var);
    }
}
