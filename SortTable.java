/**
*  FILE:  SortTable.java
*  DESCRIPTION:  contains the SortTable class
*  AUTHOR: Madilyn Simons
**/

import java.io.*;
import java.util.*;

public class SortTable{

  public static int k;

  public static void main(String[] args){


    try{
      System.out.println("How many times would you like to run each test?");
      Scanner in = new Scanner(System.in);
      k = in.nextInt();
      in.close();
    }catch(Exception e){
      k = 10;
    }
    int[] sizes = {2048, 4096, 8192, 16384};

    String it = "\nInsertion Sort";
    it += "\nsize| max\tavg\tmin";
    String mt = "\nMerge Sort";
    mt += "\nsize| max\tavg\tmin";
    String qt = "\nQuick Sort";
    qt += "\nsize| max\tavg\tmin";

    for(int size = 0; size < sizes.length; size++){

      ArrayList<Integer> insertCounts = new ArrayList<Integer>();
      ArrayList<Integer> mergeCounts = new ArrayList<Integer>();
      ArrayList<Integer> quickCounts = new ArrayList<Integer>();

      for(int x = 0; x < k; x++){

        InsertionSortTest ic = new InsertionSortTest();
        ic.main(sizes[size]);
        insertCounts.add(ic.icount);

        MergeSortTest mc = new MergeSortTest();
        mc.main(sizes[size]);
        mergeCounts.add(mc.m);

        QuickSortTest qs = new QuickSortTest();
        qs.main(sizes[size]);
        quickCounts.add(qs.qcount);

      }

      it += ("\n"+sizes[size]+" | "+max(insertCounts)+
        " | "+average(insertCounts)+" | "+min(insertCounts));
      mt += ("\n"+sizes[size]+" | "+max(mergeCounts)+
        " | "+average(mergeCounts)+" | "+min(mergeCounts));
      qt += ("\n"+sizes[size]+" | "+max(quickCounts)+
        " | "+average(quickCounts)+" | "+min(quickCounts));
    }

    System.out.println(it);
    System.out.println(mt);
    System.out.println(qt);

  }

  /**
  *  returns average of the elements in a given arraylist<Integer>
  **/
  public static int average(ArrayList<Integer> array) {
    int total = 0;
    int nums = 0;
    for(int x = 1; x<array.size(); x++){
      total += (array.get(x));
      nums += 1;
    }return total/nums;
  }

  /**
  *  returns value of the highest element in a given arraylist<Integer>
  **/
  public static int max(ArrayList<Integer> array){
    int max = array.get(0);
    for(int x = 1; x<array.size(); x++){
      if(max < array.get(x)) max = array.get(x);
    }return max;
  }

  
    /**
    *  returns value of the lowest element in a given arraylist<Integer>
    **/
  public static int min(ArrayList<Integer> array){
    int min = array.get(0);
    for(int x = 1; x<array.size(); x++){
      if(min > array.get(x)) min = array.get(x);
    }return min;
  }


}
