package by.it.halai.jd01_02;


class TaskC {

    public static int[][] fillMatrix(int n) {
        int[][] m = new int[n][n];
        System.out.println("Получим матрицу");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = (int) (-n + Math.random() * n * 2);
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        return m;
    }

    public static void solveTaskC1(int[][] m) {


        System.out.println("Найдем сумму элементов матрицы, расположенных между первым и вторым положительными элементами в каждой строке.");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > 0) {
                    int sum = 0;
                    for (int a = j + 1; a < m[0].length; a++) {
                        if (m[i][a] <= 0) {
                            sum = sum + m[i][a];
                        } else break;
                    }
                    System.out.println("line #" + (i + 1) + " sum = " + sum);
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void solveTaskC2(int[][] m, int n) {
        System.out.println();
        System.out.println("Транспонируем матрицу");
        System.out.println();
        int[][] mT = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                mT[i][j] = m[j][i];
                System.out.print(mT[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solveTaskC3(int[][] m, int n) {
        int[][] m90 = new int[n][n];
        System.out.println("Повернем матрицу на 90 градусов против часовой стрелки");
        System.out.println();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m90[i][j] = m[j][m.length - 1 - i];
                System.out.print(m90[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solveTaskC4(int[][] m, int n) {
        System.out.println("Найдем максимальный элемент в матрице");
        int max = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }
        System.out.println("Максимальный элемент в матрице равен " + max);
        System.out.println("Удалим все строки и столбцы, которые содержат максимальный элемент");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == max) {

                }
                System.out.println(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveTaskC5(int[][] m) {
        System.out.println("Найдем минимальный элемент в матрице");
        int min = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] < min) {
                    min = m[i][j];
                }
            }
        }
        System.out.println("Минимальный элемент в матрице равен " + min);
        System.out.println("Переместим минимальный элемент на позицию [1,1] матрицы");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == min) {
                    int a = m[1][1];
                    m[1][1] = min;
                    m[i][j] = a;
                }
            }
        }
        System.out.println("Матрица с перемещенными элементами:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveTaskC6(int[][] m, int n) {
        System.out.println("Переместим элементы матрицы равные 0 в конец матрицы");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                int a;
                if (m[i][j] == 0) {
                    a = m[i][n - j];
                    m[i][n - j] = 0;
                    m[i][j] = a;
                }
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
