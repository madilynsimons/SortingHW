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
    String mt = "\nMerge Sort";
    String qt = "\nQuick Sort";

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

      it += ("\n"+sizes[size]+"\t"+max(insertCounts)+
        "\t"+average(insertCounts)+"\t"+min(insertCounts));
      mt += ("\n"+sizes[size]+"\t"+max(mergeCounts)+
        "\t"+average(mergeCounts)+"\t"+min(mergeCounts));
      qt += ("\n"+sizes[size]+"\t"+max(quickCounts)+
        "\t"+average(quickCounts)+"\t"+min(quickCounts));
    }

    System.out.println(it);
    System.out.println(mt);
    System.out.println(qt);

  }

  public static int average(ArrayList<Integer> array) {
    int total = 0;
    int nums = 0;
    for(int x = 1; x<array.size(); x++){
      total += (array.get(x));
      nums += 1;
    }return total/nums;
  }

  public static int max(ArrayList<Integer> array){
    int max = array.get(0);
    for(int x = 1; x<array.size(); x++){
      if(max < array.get(x)) max = array.get(x);
    }return max;
  }

  public static int min(ArrayList<Integer> array){
    int min = array.get(0);
    for(int x = 1; x<array.size(); x++){
      if(min > array.get(x)) min = array.get(x);
    }return min;
  }


}
