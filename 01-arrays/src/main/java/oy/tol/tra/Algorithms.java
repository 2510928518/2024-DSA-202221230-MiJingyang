package oy.tol.tra;

public class Algorithms {
    public static <T>void swap(T[] array,int m,int n){
        T tmp=array[m];
        array[m]=array[n];
        array[n]=tmp;
    }
    
    public static <T extends Comparable<T>> void sort(T [] array){
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(array[j].compareTo(array[j+1])>0){
                    swap(array, j, j+1);
                }
            }
        }
    }
    
    public static <T> void reverse(T [] array){
        int head=0;
        int tail=array.length-1;
        while(head<tail){
            swap(array,head,tail);
            head++;
            tail--;
        }
    }
}