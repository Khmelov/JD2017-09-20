package by.it.likhanau.jd01_13;
import java.util.Scanner;


public class TaskA {
    public static void makeTaskA() {
        Scanner scanner = new Scanner(System.in);
        double sumOfNumSqrt = 0;
        while (true) {
            System.out.println("Enter the data, please: ");
            try {
                String data = scanner.nextLine();
                if (data.equals("END")) {
                    break;
                }
                int number = Integer.parseInt(data);
                if (number < 0) {
                    throw new ArithmeticException();
                }
                sumOfNumSqrt += Math.sqrt(number);
                System.out.println("The number is " + number + ", and the sum of square roots is " + sumOfNumSqrt + ".");
            } catch (NumberFormatException e) {
                System.err.print("Ошибка! Введенны недопустимые символы.\n");
            } catch (ArithmeticException e){
                System.err.print("Ошибка! Введено отрицательное число. Корень квадратный не может быть извлечён.\n");
            }
        }
        scanner.close();
    }
}
