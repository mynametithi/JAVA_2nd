//Move all x to the end of the string:
public class recursion_data_4 {
    public static void moveAllX(String str, int idx, int count, String newString) {
        if (idx == str.length()) {
            for (int i = 0; i < count; i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;

        }
        char currChar = str.charAt(idx);
        if (currChar == 'x') {
            count++;
            moveAllX(str, idx + 1, count, newString);
        } else {
            newString += currChar; // newString = newString + currChar;
            moveAllX(str, idx + 1, count, newString);
        }

    }

    public static void main(String[] args) {
        String str = "axbxcxdxex";
        moveAllX(str, 0, 0, " ");
    }
}
