/**
 * FILE: InsertionSortTest.java
 * DESCRIPTION: File contains the InsertionSortTest class
 * AUTHOR: Madilyn Simons
**/

import java.util.*;

public class InsertionSortTest{

  public static void main(String[] args){   
    Random gen=new Random(); int[] a=new int[15];
    int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
    System.out.println("Initial array:");
    for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
    System.out.println();
    insertionsort();
    System.out.println("Sorted array:");
    for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
    System.out.println("Done!");
    System.out.println(qcount+" qcount");
  }
  
  public static void insertionsort(){
    
  }
  
}
