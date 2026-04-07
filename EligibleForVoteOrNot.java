import java.util.Scanner;

public class EligibleForVoteOrNot {
    public static int eligibleornot(int age){
        if(age>=18){
            System.out.println("You are eligible for vote");
            return 1;
        } else {
            System.out.println("You are not eligible for vote");
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter your age:");
        Scanner input=new Scanner(System.in);
        int age=input.nextInt();
        eligibleornot(age);
        
    }
}
