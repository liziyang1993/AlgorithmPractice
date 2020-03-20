import java.text.ParseException;
import java.util.Scanner;

public class Test {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || str.length() < n) return str;
        char[] array = str.toCharArray();
        reverse(array, 0, array.length - 1);
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - n - 1);
        return String.valueOf(array);
    }

    public void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) throws ParseException {
        Test test = new Test();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str1 = str.split(";")[0];
        String str2 = str.split(";")[1];
        for (int i = 1; i < str1.length(); i++) {
            String reverse = test.LeftRotateString(str1, i);
            if (reverse.equals(str2)) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

}
