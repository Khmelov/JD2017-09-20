package by.it.meshchenko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OperationCore {
    // Методы операций для различных типов переменных.
    // Операции могут быть одинаковы при перестановке местами переменных.

    // Add: VarF + VarF
    static Var add_FF(VarF v1, VarF v2){
        return new VarF(v1.getValue() + v2.getValue());
    }
    // Add: VarF + VarV  <--> VarV + VarF
    static Var add_VF(VarV v1, VarF v2){
        VarV result = new VarV(v1.getValue());
        double[] resultVal = result.getValue();
        double operand2 = v2.getValue();
        for (int i = 0; i < resultVal.length; i++) {
            resultVal[i] += operand2;
        }
        return result;
    }
    // Add: VarF + VarM <---> VarM + VarF
    static Var add_MF(VarM v1, VarF v2){
        VarM result = new VarM(v1.getValue());
        double[][] resultVal = result.getValue();
        double operand2 = v2.getValue();
        for (int i = 0; i < resultVal.length; i++) {
            for (int j = 0; j < resultVal[i].length; j++) {
                resultVal[i][j] += operand2;
            }
        }
        return result;
    }
    // Add: VarV + VarV
    static Var add_VV(VarV v1, VarV v2){
        VarV result = null;
        try{
            if(v1.getValue().length == v1.getValue().length) {
                result = new VarV(v1.getValue());
                double[] resultVal = result.getValue();
                double[] operand2 = v2.getValue();
                for (int i = 0; i < resultVal.length; i++) {
                    resultVal[i] += operand2[i];
                }
            } else { throw new CalcErrorException("Ошибка: сложение невозможно, несоответствие размерности векторов"); }
        }
        catch (CalcErrorException e){
            //Util.printException(e);
        }
        return result;
    }
    // Add: VarM + VarM
    static Var add_MM(VarM v1, VarM v2){
        VarM result = null;
        try{
            if(v1.getValue().length == v1.getValue().length
                    && v1.getValue()[0].length == v1.getValue()[0].length) {
                result = new VarM(v1.getValue());
                double[][] resultVal = result.getValue();
                double[][] operand2 = v2.getValue();
                for (int i = 0; i < resultVal.length; i++) {
                    for (int j = 0; j < resultVal[i].length; j++) {
                        resultVal[i][j] += operand2[i][j];
                    }
                }
            } else {
                throw new CalcErrorException("Ошибка: сложение невозможно, несоответствие размерности матрицы и вектора");
            }
        }
        catch (CalcErrorException e){
            //Util.printException(e);
        }
        return result;
    }


    // Div: VarF / VarF
    static Var div_FF(VarF v1, VarF v2) {
        VarF res = null;
        try{
            if(v2.getValue() != 0) {
                res = new VarF(v1.getValue() / v2.getValue());
            } else {
                throw new CalcErrorException("Ошибка: деление на ноль");
            }
        }
        catch (CalcErrorException e){
            //Util.printException(e);
        }
        return res;
    }
    // Div: VarV / VarF
    static Var div_VF(VarV v1, VarF v2){
        VarV res = null;
        try{
            if(v2.getValue() != 0) {
                res = new VarV(v1.getValue());
                double[] resultVal = res.getValue();
                double operand2 = v2.getValue();
                for (int i = 0; i < resultVal.length; i++) {
                    resultVal[i] /= operand2;
                }
            } else {
                throw new CalcErrorException("Ошибка: деление на ноль");
            }
        }
        catch (CalcErrorException e){
            //Util.printException(e);
        }
        return res;
    }
    // Div: VarM / VarF
    static Var div_MF(VarM v1, VarF v2){
        VarM res = null;
        try{
            if(v2.getValue() != 0) {
                res = new VarM(v1.getValue());
                double[][] resultVal = res.getValue();
                double operand2 = v2.getValue();
                for (int i = 0; i < resultVal.length; i++) {
                    for (int j = 0; j < resultVal[i].length; j++) {
                        resultVal[i][j] /= operand2;
                    }
                }
            } else {
                throw new CalcErrorException("Ошибка: деление на ноль");
            }
        }
        catch (CalcErrorException e){
            //Util.printException(e);
        }
        return res;
    }


    // Mul: VarF * VarF
    static Var mul_FF(VarF v1, VarF v2) {
        return new VarF(v1.getValue() * v2.getValue());
    }
    // Mul: VarF * VarV <---> VarV * VarF
    static Var mul_FV(VarF v1, VarV v2){
        VarV result = new VarV(v2.getValue());
        double[] resultVal = result.getValue();
        double operand2 = v1.getValue();
        for (int i = 0; i < resultVal.length; i++) {
            resultVal[i] *= operand2;
        }
        return result;
    }
    // Mul: VarF * VarM <---> VarM * VarF
    static Var mul_FM(VarF v1, VarM v2){
        VarM result = new VarM(v2.getValue());
        double[][] resultVal = result.getValue();
        double operand2 = v1.getValue();
        for (int i = 0; i < resultVal.length; i++) {
            for (int j = 0; j < resultVal[i].length; j++) {
                resultVal[i][j] *= operand2;
            }
        }
        return result;
    }
    // Mul: VarV * VarV - не реализовано необходимо менять класс VarV
    // Mul: VarV * VarM
    static Var mul_VM(VarV v1, VarM v2){
        double[] size = v1.getValue();
        double[][] operator = new double[1][size.length];
        for(int i = 0; i < size.length; i++ ){
            operator[0][i] = size[i];
        }
        return mul_MM(new VarM(operator), v2);
    }
    // Mul: VarM * VarV
    static Var mul_MV(VarM v1, VarV v2){
        double[] size = v2.getValue();
        double[][] operator = new double[1][size.length];
        for(int i = 0; i < size.length; i++ ){
            operator[0][i] = size[i];
        }
        return mul_MM(v1, new VarM(operator));
    }
    // Mul: VarM * VarM
    static Var mul_MM(VarM v1, VarM v2){
        VarM result = null;
        if(v1 != null && v2 != null){
            double[][] resV1 = v1.getValue();
            double[][] resV2 = v2.getValue();
            int m = resV1.length;
            int n1 = resV1[0].length;
            int n2 = resV2.length;
            int k = resV2[0].length;
            try{
                if(m > 0 && n1 > 0 && n2 > 0 && k > 0 && n1 == n2){
                    result = new VarM(new double[m][k]);
                    double[][] res = result.getValue();
                    for(int ci = 0; ci < m; ci++){
                        for(int cj = 0 ; cj < k; cj++){
                            for(int n = 0; n < n1; n++){
                                res[ci][cj] =  res[ci][cj] + resV1[ci][n] * resV2[n][cj];
                            }
                        }
                    }
                }else {
                    throw new CalcErrorException("Ошибка: умножение невозможно, несоответствие размерности множителей");
                }
            }
            catch (CalcErrorException e){
                //Util.printException(e);
            }
        }
        return result;
    }


    // Sub: VarF - VarF
    static Var sub_FF(VarF v1, VarF v2){
        return add_FF(v1, new VarF(-v2.getValue()));
    }
    // Sub: VarV - VarF
    static Var sub_VF(VarV v1, VarF v2){
        return add_VF(v1, new VarF(-v2.getValue()));
    }
    // Sub: VarM - VarF
    static Var sub_MF(VarM v1, VarF v2){
        return add_MF(v1, new VarF(-v2.getValue()));
    }
    // Sub: VarV - VarV - не реализовано необходимо менять класс VarV

    static Double PatternExValToDouble(String strValue){
        Double res = null;
        Pattern p = Pattern.compile(Patterns.exValsimpl);
        Matcher m = p.matcher(strValue);
        try{
            if(m.matches()) {
                return res = Double.parseDouble(strValue);
            }
            p = Pattern.compile(Patterns.exValcomlp);
            m = p.matcher(strValue);
            if(m.matches()){
                return res = Double.parseDouble(strValue.substring(1, strValue.length()-1));
            }
        }
        catch (ClassCastException e){}
        return res;
    }
}
