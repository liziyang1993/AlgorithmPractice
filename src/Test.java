import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) list.add(i);
        list.remove(list.size() - 1);
        list.add(11);
        int x = list.get(list.size() - 1);
        System.out.println();
    }
}
