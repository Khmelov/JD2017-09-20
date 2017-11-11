package by.it.halai.jd01_02;


import java.io.IOException;


public class Runner {

    public static void main(String[] args) throws IOException {

//        //Выплнение заданий категории А
//        //прочитаем линию заданную с клавиатуры
//        System.out.println("Введите числа для массива");
//        String line = Utils.getOneLine();
//        //получим массив чисел, с которым будем работать
//        int arr[] = Utils.lineToIntArray(line);
//
//        //A.1. Найти самое короткое и самое длинное число. Вывести их и их длину на консоль.
//        String max = TaskA.getMax(arr);
//        System.out.println(max);
//        String min = TaskA.getMin(arr);
//        System.out.println(min);
//
//        //A.2. вывести на консоль те числа, меньше(больше) средней.
//        double mean = TaskA.mean(arr);
//        System.out.print("Числа меньше " + mean + " таковы: ");
//        for (int i : arr) {
//            if (i < mean) {
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println();
//        System.out.print("Числа больше " + mean + " таковы: ");
//        for (int i : arr) {
//            if (i > mean) {
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println();
//
//        //A.3. Найти число, состоящее только из разных цифр. Если таких чисел несколько, то найти первое из них.
//        for (int i : arr) {
//            if (TaskA.uniqueDigits(i)) {
//                System.out.println("Найдено число из разных цифр: " + i);
//                break;  //больше ничего не ищем
//            }
//        }
//
//
//        //Выполнение заданий категории В
//        //В.1. Вывести числа от 1 до k в виде матрицы NxN слева направо и сверху вниз
//        //(k выберите квадратом целого числа, например - 25, т.е. N будет равен 5)
//
//        System.out.println("Введите число k, которое будет квадратом целого числа");
//        //прочитаем строку заданную с клавиатуры
//        String str = Utils.getOneLine();
//        //получим число, с которым будем работать
//        int k = Utils.lineToIntNumber(str);
//        //рассчитаем, заполним и выведем на консоль полученный массив
//        TaskB.getArray(k);
//
//        //B.2. Рассчитайте и выведите корни квадратного уравнения.
//        //Параметры (a, b, c) нужно передавать с командной строки.
//        System.out.println("Расчитаем корни квадратного уравнения");
//        //прочитаем строки, заданные с клавиатуры
//        System.out.println("Введите a:");
//        String strA = Utils.getOneLine();
//        System.out.println("Введите b:");
//        String strB = Utils.getOneLine();
//        System.out.println("Введите c:");
//        String strC = Utils.getOneLine();
//        //получим числа, с которыми будем работать
//        double a = Utils.lineToDoubleNumber(strA);
//        double b = Utils.lineToDoubleNumber(strB);
//        double c = Utils.lineToDoubleNumber(strC);
//        //Рассчитаем и выведем на консоль корни квадратного уравнения
//        String ur = TaskB.getX12(a, b, c);
//        System.out.println(ur);
//
//        //B.3. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующее данному месяцу.
//        //Осуществить проверку корректности ввода чисел и сообщить об ошибке.
//        System.out.println("Введите целое число от 1 до 12");
//
//        //прочитаем строку, заданную с клавиатуры
//        String lineNumber = Utils.getOneLine();
//
//        //получим число, с которым будем работать
//        int inNumber = Utils.lineToIntNumber(lineNumber);
//
//        //Выводим соответсвующее название месяца введенному числу
//        String nameOfMonth = TaskB.getNameOfMonth(inNumber);
//        System.out.println(nameOfMonth);


        //Здания уровня С
        //Создаим матрицу размером n
        System.out.println("Введите целое число n:");   //зададим размерность матрицы
        String strN = Utils.getOneLine();               //прочитаем строку с консоли
        int n = Utils.lineToIntNumber(strN);            //строку переведем в целое число
        System.out.println("Заполним матрицу");
        int[][] m = TaskC.fillMatrix(n);

        //C.1. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.
        System.out.println("Задание С.1.");
        TaskC.solveTaskC1(m);
        System.out.println("Задание С.2.");
        TaskC.solveTaskC2(m, n);
        System.out.println("Задание С.3.");
        TaskC.solveTaskC3(m, n);
        System.out.println("Задание С.4.");
        TaskC.solveTaskC4(m, n);
        System.out.println("Задание С.5.");
        TaskC.solveTaskC5(m);
        System.out.println("Задание С.6.");
        TaskC.solveTaskC6(m, n);
    }
}
