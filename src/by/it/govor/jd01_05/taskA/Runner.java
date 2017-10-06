package by.it.govor.jd01_05.taskA;

import by.it.govor.jd01_05.taskA.task1.Task1;
import by.it.govor.jd01_05.taskA.task3.Task3;
import by.it.govor.jd01_05.taskA.task2.Task2;

import java.io.IOException;

/**
 * Created by User on 02.10.2017.
 */
public class Runner {
    public static void main(String[] args) throws IOException {
Task1.task1();
        Task2.task2();
        Task3.task3();
    }
}
