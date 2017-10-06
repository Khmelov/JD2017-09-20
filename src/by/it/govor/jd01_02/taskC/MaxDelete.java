package by.it.govor.jd01_02.taskC;

public class MaxDelete {
    public static void delete(int[][] mas,int size) {
        System.out.println();
        System.out.println("Остаток от массива(Задание №4)");
        int col=0;
        int max=(size+1)*-1;
        int masline1[] = new int[size*2];
        int masline2[] = new int[size*2];
        int g=0;
        int y=0;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                if (mas[i][j]>max){

                    max=mas[i][j];

                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size ; j++) {
                if(max==mas[i][j]){
                    col++;
                    masline1[g]=i;
                    masline2[y]=j;
                    g++;
                    y++;
                }
            }
        }
        boolean ia=false;
        boolean ja=false;
        int[][] masDelete = new int[size][size];
        System.out.println();



            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    for (int l = 0; l <col ; l++) {
                    if (i==masline1[l]){
                        ia=true;

                    }else{ia=false;}
                        if (j==masline2[l]){
                            ja=true;

                        }else{ja=false;}
                    }
                    if(ja==false && ia==false){
                        System.out.print(mas[i][j]+" ");
                    }

                }
                System.out.println();
            }

    }

}
