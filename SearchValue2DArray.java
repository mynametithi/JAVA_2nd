import java.util.Scanner;

public class SearchValue2DArray {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows and columns:");
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] arr=new int[rows][cols];
        //input
    System.out.println("Enter the elements of the array:");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        //search
    System.out.println("Enter the value to search:");
        int value=sc.nextInt();
        boolean found=false;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(arr[i][j]==value){
                    System.out.println("Value found at position ("+i+","+j+")");
                    found=true;
                }
            }
        }
        if(!found){
            System.out.println("Value not found");
        }
    }
}
