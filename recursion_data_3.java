//print sum of n natural number:
public class recursion_data_3 {
    public static void PrintSum(int i, int n, int sum) {
        if (i == n) {
            sum += i;
            System.out.println(sum);
            return;
        }
        sum += i;
        PrintSum(i + 1, n, sum);
    }

    public static void main(String[] args) {
        PrintSum(1, 5, 0);
    }
}
