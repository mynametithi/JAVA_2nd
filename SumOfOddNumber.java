
import java.util.Scanner;

public class SumOfOddNumber {
    public static int Oddsum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                sum+=i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        System.out.println("The sum of odd numbers is: " + Oddsum(n));
    }
}
