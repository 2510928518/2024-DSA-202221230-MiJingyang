package oy.tol.tra;


public class Grades<T extends Comparable<T>> {
   
   private T [] grades = null;

   public Grades(T [] grades) {
      this.grades = grades.clone();
      }
   

   public void reverse() {
      Algorithms.reverse(grades);
   }

   
   public void sort() {  
      Algorithms.sort(grades);
   }

   public T [] getArray() {
      return grades.clone();
   }
}
