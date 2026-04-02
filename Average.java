
import java.util.Scanner;

public class Average {
    public static double average(int a,int b,int c){
        Scanner sc=new Scanner(System.in);
        return (a + b + c) / 3.0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("The average is: " + average(a, b, c));
    }
}
