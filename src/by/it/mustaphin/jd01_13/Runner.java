package by.it.mustaphin.jd01_13;

public class Runner {
    public static void main(String[] args) {
//        Singleton tA = new Singleton();
//        tA.read();

        try {
            System.out.println("Start level 0");
            new TaskB().level1();
            throw new MyExceptioin("Мое исключение");
        } catch (IndexOutOfBoundsException | IllegalArgumentException | MyExceptioin e) {
            e.printStackTrace();
        } finally {
            System.out.println("End level 0");
        }
    }
}
