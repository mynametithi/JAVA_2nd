//print 1to 5 number using recursive functon:
public class recursion_data_2 {
    public static void printNum(int n) {
        if (n == 6) {
            return;
        }
        System.out.println(n);
        printNum(n + 1);
    }

    public static void main(String[] args) {
        int n = 1;
        printNum(n);// n=5
    }
}
