package by.it.govor.jd01_02.taskA.task2;

/**
 * Created by User on 25.09.2017.
 */
public class MinNormalMas {
  private   double sum=0;
   private double normal;
    public void minNormalMas() throws Exception{
        int[] Intmas = Mas.masInt();
        for(int i =0;i<Intmas.length;i++){
            sum+=Intmas[i];
        }
        normal=sum/Intmas.length;
        for(int i =0;i<Intmas.length;i++){
            if(normal>Intmas[i]){
                System.out.print(Intmas[i]+" ");

            }

        }
        System.out.println();
        System.out.println("Длина строки="+Intmas.length+"\n"+"Средние значение="+normal );
    }
}
