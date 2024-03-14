package oy.tol.tra;


public class Grades<T extends Comparable<T>> {
   
   private T [] grades = null;

   public Grades(T [] grades) {
      this.grades = grades.clone();
      }
   

   public void reverse() {
      int head = 0;
      int tail = grades.length - 1;
      while (head<tail) {
         T temp = grades[head];
         grades[head] = grades[tail];
         grades[tail] = temp;
         head++;
         tail--;
     }
   }

   
   public void sort() {  
      boolean swapped;
      do{
         swapped=false;
         for(int i=1; i<grades.length;i++){
            if (grades[i-1].compareTo(grades[i])>0) {
               T temp = grades[i-1];
               grades[i-1]=grades[i];
               grades[i]= temp;
               swapped = true;
            }
         }
      } while (swapped);
   }

   public T [] getArray() {
      return grades.clone();
   }
}
