package by.it.govor.jd01_02.taskA.task1;

/**
 * Created by User on 25.09.2017.
 */
public class MinMaxMas {

    private int[] intMas; //доступ только в классе
    protected   void minMaxMas() throws Exception { //доступ только в папке и наследникам
        String[] StrMas = Mas.masStr();
         intMas = new int[StrMas.length];
        for (int i=0; i<intMas.length;i++){
            intMas[i] =Integer.parseInt(StrMas[i]);
        }
        int minInt = 0;
        int maxInt = 0;
        int minLine=intMas.length;
        int maxLine=0;

        for (int j=0;j<intMas.length;j++){
            if (StrMas[j].length()>maxLine){
                maxInt=intMas[j];
                maxLine=StrMas[j].length();
            }
            if (StrMas[j].length()<minLine){
                minInt=intMas[j];
               minLine= StrMas[j].length();
            }
        }
        System.out.println("MIn="+minInt+" Length "+minLine+"\n"+"MAX="+maxInt+" Length "+maxLine);


    }
}
