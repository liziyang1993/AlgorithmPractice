import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 3 5 7
 */
public class Main {

    static int k = 6;

    public static List<String> combine(String input, List<String> combineResult) {
        choose(input, new StringBuilder(), 0, combineResult);
        return combineResult;
    }

    public static void choose(String input, StringBuilder builder, int index, List<String> combineResult) {
        if (builder.length() == k) {
            combineResult.add(builder.toString());
            return;
        }
        for (int i = index; i < input.length(); i++) {
            builder.append(input.charAt(i));
            choose(input, builder, i + 1, combineResult);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static Set<String> permute(char[] array, Set<String> permuteResult) {
        backTrack(0, array, permuteResult);
        return permuteResult;
    }

    public static void backTrack(int begin, char[] array, Set<String> permuteResult) {
        if (begin == array.length - 1) {
            permuteResult.add(String.valueOf(array));
            return;
        }
        for (int i = begin; i < array.length; i++) {
            char temp = array[begin];
            array[begin] = array[i];
            array[i] = temp;
            backTrack(begin + 1, array, permuteResult);
            temp = array[begin];
            array[begin] = array[i];
            array[i] = temp;
        }
    }

    public static Date format(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        sdf.setLenient(false);
        Date date = null;
        try {
            date = sdf.parse(value);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> list1 = new ArrayList<>(list);

    }

}