import java.util.Scanner;
public class nameArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size=sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String names[]=new String[size];
        System.out.println("Enter your favourite names:");
        for(int i=0;i<size;i++){
            names[i]=sc.nextLine();
        }
        for(int i=0;i<names.length;i++){
            System.out.println("name"+(i+1)+":"+names[i]);
        }
    }
}
