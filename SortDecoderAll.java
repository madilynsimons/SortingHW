//This program requires two command line parameters f - the "encoded" file
//and fkey - the dat file with the "key" to decoding f. Both are binary files.
//It ouputs the "decoded" version of f.
import java.io.*;
import java.util.*;

public class SortDecoderAll
{
 public static void main(String[] args)
 {
  int i, n=1; entry[] array = new entry[1000000];
  for (int h=1; h<1000000; h++) array[h]=new entry();
  try
  {
         DataInputStream ins=new DataInputStream(new FileInputStream(args[0]));
         DataInputStream inskey=new DataInputStream(new FileInputStream(args[1]));
   try
   {
    while (true)
    {
     array[n].key=inskey.readInt();;
     array[n].b=ins.readByte();
     n++;
    }
   }
   catch(EOFException e)
   {
    System.out.println("Done reading file.");
   }
   ins.close(); inskey.close();
  }
  catch(FileNotFoundException e)
  {
   System.out.println("Cannot find file.");
  }
  catch(IOException e)
  {
   System.out.println("Input problem with file.");
  }
  n--; System.out.println("n is "+n);
  mergesort(array, 1, n);
  insertionsort(array, n);
  quicksort(array, 1, n);
  try
  {
   DataOutputStream outs=new DataOutputStream(new FileOutputStream("decoded"+args[0]));
   for (i=1; i<=n; i++) outs.writeByte(array[i].b);
   outs.close();
   System.out.println("The output file is "+"decoded"+args[0]);
  }
  catch(FileNotFoundException e)
  {
   System.out.println("Cannot find file.");
  }
  catch(IOException e)
  {
   System.out.println("Input problem with file.");
  }
 }

/**
* sorts array using insert sort algorithm
**/
  public static void insertionsort(entry[] data, int n){
    for(int x = 1; x < n; x++){
      int j = x;
      int insert = x+1;
      while(j > 0 && data[insert].key < data[j].key){
        entry temp = data[j];
        data[j] = data[insert];
        data[insert] = temp;
        j--; insert--;
      }
      System.out.println(x +" out of "+n);
    }
  }

  /**
  * sorts array using quick sort algorithm
  **/
  public static void quicksort (entry[] data, int i, int j){
    int p;
    if(i<j){
      p = partition(data, i, j);
      quicksort (data,i,p);
      quicksort (data,p+1,j);
    }
  }

  public static int partition (entry[] data, int i, int j){
    int left, right;
    entry pivot;

    left = i; right = j; pivot=data[i];
    while(left < right){
      while((left < right) && (pivot.key <=data[right].key)) right--;
      if(left < right){
        entry temp = data[right];
        data[right]=data[left];
        data[left]= temp;
      }
      while((left < right) && (pivot.key >= data[left].key)) left++;
      if(left < right){
        entry temp = data[right];
        data[right]=data[left];
        data[left]= temp;
      }
    }
    data[left]=pivot;
    return(left);
  }

  /**
  * sorts array using merge sort algorithm
  **/
 public static void mergesort(entry[] a, int top, int bottom)
 {
  if (top!=bottom)
  {
     int middle=(top+bottom)/2;
      mergesort(a, top, middle);
      mergesort(a, middle+1, bottom);
      merge(a, top, bottom);
  }
 }

 public static void merge(entry[] a, int top, int bottom)
 {
  int t=top; int middle=(top+bottom)/2; int b=middle+1; int i=0;
  entry[] s=new entry[bottom-top+1];
  while ((t<=middle)&&(b<=bottom))
  {
      if (a[t].key < a[b].key) {s[i]=a[t]; t++;}
    else {s[i]=a[b]; b++;}
      i++;
  }
  int last=middle;
  if (b<=bottom) {t=b; last=bottom;}
  while (t<=last) {s[i]=a[t]; t++; i++;}
  for (i=0; i<s.length; i++) {a[i+top]=s[i];}
 }

 public static class entry
	{
		int key; byte b;

		public entry(){}
	}

}
