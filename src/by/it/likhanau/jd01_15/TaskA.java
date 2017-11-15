package by.it.likhanau.jd01_15;


public class TaskA {
    public static void makeTaskA() {
        initializeArray();
    }

    private static void initializeArray() {
        int[][] array = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 15 - (int)(Math.random() * 30);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


}

