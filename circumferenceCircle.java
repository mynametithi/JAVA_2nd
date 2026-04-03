import java.util.Scanner;

public class circumferenceCircle {
    public static double circumference(int r){
        return 2 * Math.PI * r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        int r = sc.nextInt();
        System.out.println("The circumference of the circle is: " + circumference(r));
    }
}
