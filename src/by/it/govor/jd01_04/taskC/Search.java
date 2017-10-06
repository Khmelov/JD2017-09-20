package by.it.govor.jd01_04.taskC;


 class Search {
     protected static int search(int k, int min, int size, int[] mas) {
         if (min > size) {
             return -1;
         }
         int mid = min + (size - min) / 2;
         if (k < mas[mid]) {
             return search(k, min, mid - 1, mas);
         } else if (k > mas[mid]) {
             return search(k, mid + 1, size, mas);
         } else return mid;
     }

}
