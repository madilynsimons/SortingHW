/**
 * FILE: QuickSort.java
 * DESCRIPTION: File contains the QuickSortTest class
 * AUTHOR: Madilyn Simons
**/

import java.util.*;

public class QuickSortTest{

  static int qcount = 0;

  public static void main(String[] args){
    Random gen=new Random(); int[] a=new int[15];
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
   * Sorts array data using the quicksort algorithm
  **/
  public static void quicksort (int[] data, int i, int j){

    int p; int low = i; int high = j;
    p = data[low + (high-low)/2];
    while(low < high){
      while(data[low] < p) low++;
      while(data[high] > p) high--;
      if(low<=high){
        qcount++;
        int temp = data[high];
        data[high] = data[low];
        data[low] = temp;
        low++; high--;
      }
    }
    if(i<high)quicksort (data,i,high);
    if(j>low)quicksort (data,low,j);
    
  }
  
}
