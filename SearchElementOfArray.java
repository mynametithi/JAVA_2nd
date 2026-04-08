
import java.util.Scanner;

class SearchElementOfArray{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       // input size
        System.out.println("Enter the size of array:");
        int size=sc.nextInt();
        int[] number=new int[size];
        //input elements of array
        System.out.println("Enter the elements of array:");
        for(int i=0;i<size;i++){
            number[i]=sc.nextInt();
        }
        System.out.println("Enter the element to search:");
int x=sc.nextInt();
//search array
for(int i=0;i<number.length;i++){
    if(number[i]==x){
        System.out.println("x found at index:"+i);
    }
System.out.println("x not found in array");
    }
}
}