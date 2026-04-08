import java.util.Scanner;
public class SortedArray {
    public static void main(String[] args) {
        //take array size
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
      int size=sc.nextInt();
      int numbers[]=new int[size];
      //take input
      System.out.println("Enter the elements of array:");
      for(int i=0;i<size;i++){
        numbers[i]=sc.nextInt();
      }
      boolean isSorted=true;
      for(int i=0;i<size-1;i++){
        if(numbers[i]>numbers[i+1]){
            isSorted=false;
            break;
        }
      }
      if(isSorted){
        System.out.println("The array is sorted.");
      }else{
        System.out.println("The array is not sorted.");
      }
    }
}
