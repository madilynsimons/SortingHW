import java.util.*;

public class QuickSortTest{

  static int qcount = 0;

  public static void main(String[] args){
    Random gen=new Random(); int[] a=new int[10];
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

  public static void quicksort (int[] data, int i, int j){
    int p; int low = i; int high = j;
    p = (high-low)/2 + low;
    while(low < high){
      while(data[low] < data[p]) low++;
      while(data[high]>data[p]) high--;
      if(low<high){
        qcount++;
        int temp = data[high];
        data[high] = data[low];
        data[low] = temp;
        low++; high--;
      }
    }
    if(low<j) quicksort (data,i,p);
    if(i<high) quicksort (data,p,j);
  }

}
