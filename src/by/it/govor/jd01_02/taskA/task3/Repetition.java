package by.it.govor.jd01_02.taskA.task3;

//import by.it.govor.par2.par2_1.par2_1_2.Mas;

import by.it.govor.jd01_02.taskA.task2.Mas;

/**
 * Created by User on 25.09.2017.
 */
 public  class Repetition {
  private  int breaks;
  private  int nul=0;
    public int repetition() throws Exception {

        int[] masInt = Mas.masInt();
        for (int i = 0; i < masInt.length; i++) {
            char[] line = Integer.toString(masInt[i]).toCharArray();
            breaks=0;
            for(int k=0; k<line.length;k++){
            for(int j =0;j<line.length;j++) {
                if (j + 1 < line.length && j!=k) {
                    if (line[j] == line[k]) {
                        breaks++;
                    }
                }

            }
            }
            if (breaks == 0) {
                return masInt[i];
            }
        }
    return nul;
    }
}

