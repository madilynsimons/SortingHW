/**
 * FILE: QuickSort.java
 * DESCRIPTION: File contains the QuickSortTest class
 * AUTHOR: Madilyn Simons
**/

import java.util.*;

public class QuickSortTest{

  static int qcount = 0;

  public static void main(String[] args){
    Random gen=new Random(); int[] a=new int[32];
    int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
    System.out.println("Initial array:");
    for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
    System.out.println();
    quicksort(a, 0, a.length-1);
    System.out.println("Sorted array:");
    for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
    System.out.println("Done!");
    System.out.println(qcount+" qcount");
  }


     /**
     * tests the quicksort method with an array of index n
     **/
  public static void main(int n){
    Random gen=new Random(); int[] a=new int[n];
    int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
    quicksort(a, 0, a.length - 1);
  }

  /**
   * Sorts array data using the quicksort algorithm
  **/
  public static void quicksort (int[] data, int i, int j){
    int p;
    if(i<j){
      p = partition(data, i, j);
      quicksort (data,i,p);
      quicksort (data,p+1,j);
    }
  }

  /**
  * partitions the array between index i and index j
  * returns index point of the pivot
  **/
  public static int partition (int[] data, int i, int j){
    int left, right, pivot;

    left = i; right = j; pivot=data[i];
    while(left < right){
      while((left < right) && (pivot <=data[right])){
        qcount++;
        right--;
      }
      if(left < right){
        int temp = data[right];
        data[right]=data[left];
        data[left]= temp;
      }
      while((left < right) && (pivot >= data[left])){
        qcount++;
        left++;
      }
      if(left < right){
        int temp = data[right];
        data[right]=data[left];
        data[left]= temp;
      }
   }
   data[left]=pivot;
   return(left);
 }


}
