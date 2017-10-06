package by.it.govor.jd01_04.taskC;

import java.util.Arrays;


class Sort {
    static int[] sort() {
       int[] mas = {1, 2, 5, 2, 8, 6, 5,6,7,4,1,3,2,2,};

       int[] masGood = mas;
       Arrays.sort(masGood);
       System.out.println("Array.sort");
       System.out.println(Arrays.toString(masGood));

       System.out.println("My.sort");

       System.out.println(Arrays.toString (sort(mas)));
return sort(mas);
   }

    static int[] sort(int[] mas) {

       if (mas.length!= 1) {
           int m;
            m = (mas.length) / 2;
          // sort(mas, a, m); sort(mas, m + 1, size);
         int  n= mas.length-m;
          int[] mas1 = new int[m];
           int[] mas2 = new int[n];
           for (int i = 0; i <m ; i++) {
               mas1[i]=mas[i];
           }
           for (int i = 0; i <n ; i++) {
               mas2[i]=mas[m+i];
           }
           mas1= sort(mas1);
           mas2= sort(mas2);
           return sort(mas1,mas2);

       }
return mas;
   }

    static int[] sort(int[] mas1, int[] mas2) {
       int i = 0;
       int j = 0;

       int[] res = new int[mas1.length + mas2.length];
       for (int k = 0; k < res.length; k++) {
           if (j==mas2.length || (i<mas1.length && mas1[i] < mas2[j])) {
               res[k] = mas1[i];
               i++;


           }else {
               res[k]=mas2[j];
               j++;
           }
       }
       return res;
   }
}
