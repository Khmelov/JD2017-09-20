package by.it.meshchenko.calc;

interface Patterns {
    //возможные примеры регулярных выражений (конечно лучше составить свои).
    String exValsimpl = "((-?)([0-9.])+)";                   //числа:   0, 1.1, -1, -10.9
    String exValcomlp = "(((\\(-){1})([0-9.])+)(\\){1})";    //числа: (-1), (-10.9)
    String exVal = "(("+exValsimpl+")|("+exValcomlp+"))";   //числа
    String exVec = "\\{((-?([0-9.])+),?)+}";                //вектора
    String exMat = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
    String exAny = "("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
    String exOper = "(?<![-\\{,\\(]|^)[-+*/]";                               //операция
    String exFull = "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")";                                //выражение целиком
    String exAssign = "=";
    String nameVar = "((_?)([A-Za-z]{1})([A-Za-z0-9_]+)?)"; // Название переменной
    String exAnyANDnameVar = "("+exAny+")|("+nameVar+")";
    String exAssignNameVarValue = "("+ nameVar +")"+"(" +exAssign+")"+"(" +exAny +")";
    String exPriorOp1= "(^|(?<=[+-/*]))("+ exAnyANDnameVar +")[*/]("+ exAnyANDnameVar +")(?=[+-/*]|$)";
    String exPriorOp2= "(^|(?<=[+-/*]))("+ exAnyANDnameVar +")[+-]("+ exAnyANDnameVar +")(?=[+-/*]|$)";
}
