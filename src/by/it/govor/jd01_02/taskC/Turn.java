package by.it.govor.jd01_02.taskC;

/**
 * Created by User on 26.09.2017.
 */
public class Turn {
    public static void turn(int[][] mas, int size) {
        System.out.println("Поворот против часавой стрелки(Задание №3)");
int[][] turnMas= new int[size][size];
        System.out.println();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                turnMas[i][j] = mas[j][size-i-1];
                System.out.print(turnMas[i][j]+" ");
            }
            System.out.println();
        }

    }
}
