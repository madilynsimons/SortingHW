/**
 * FILE: InsertionSortTest.java
 * DESCRIPTION: File contains the InsertionSortTest class
 * AUTHOR: Madilyn Simons
**/

import java.util.*;

public class InsertionSortTest{

  public static int icount = 0;

  public static void main(String[] args){
    Random gen=new Random(); int[] a=new int[32];
    int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
    System.out.println("Initial array:");
    for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
    System.out.println();
    insertionsort(a);
    System.out.println("Sorted array:");
    for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
    System.out.println("Done!");
    System.out.println(icount+" icount");
  }

     /**
     * tests the insertsort method with an array of index n
     **/
  public static void main(int n){
    icount = 0;
    Random gen=new Random(); int[] a=new int[n];
    int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
    insertionsort(a);
  }

  /**
  *  sorts an array using the insert sort method
  **/
  public static void insertionsort(int[] data){
    for(int x = 0; x < data.length-1; x++){
      int j = x;
      int insert = x+1;
      while(j > -1 && data[insert] < data[j]){
        icount++;
        int temp = data[j];
        data[j] = data[insert];
        data[insert] = temp;
        j--; insert--;
      }
    }
  }

}
