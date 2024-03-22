package oy.tol.tra;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.Comparator;


public class Algorithms {
    public static <T>void swap(T[] array,int m,int n){
        T tmp=array[m];
        array[m]=array[n];
        array[n]=tmp;
    }

    public static <T extends Comparable<T>> void sort(T [] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
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
    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
        while(fromIndex<=toIndex){
            int mid=fromIndex+(toIndex-fromIndex)/2;
            if(aValue.compareTo(fromArray[mid])>0){
                fromIndex=mid+1;
            }else if(aValue.compareTo(fromArray[mid])<0){
                toIndex=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> void fastSort(E [] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E [] array, int begin, int end) {
        if(begin<end){
            int partitionIndex=partition(array, begin, end);
            quickSort(array, begin, partitionIndex-1);
            quickSort(array, partitionIndex+1, end);
        }else{
            return;
        }
        
    }

    private static <E extends Comparable<E>> int partition(E [] array, int begin, int end) {
        E p=array[begin];
        int head=begin;
        int tail=end;
        while(head!=tail){
            while ((head<tail)&&array[tail].compareTo(p)>0) {
                tail--;
            }
            while ((head<tail)&&array[head].compareTo(p)<=0) {
                head++;
            }
            if(head<tail){
                swap(array, head, tail);
            }
        }
        array[begin]=array[head];
        array[head]=p;
        return head;
    }


    public static <T> int partitionByRule(T [] pairs,int count,Predicate<T> judgeNullPredicate){
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            while (left <= right && !judgeNullPredicate.test(pairs[left])) {
                left++;
            }

            while (left <= right && judgeNullPredicate.test(pairs[right])) {
                right--;
            }

            if (left < right) {
                swap(pairs, left, right);
                left++;
                right--;
            }
        }
        return left;

    }
    
    public static <T> void sortWithComparator( T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }
}
