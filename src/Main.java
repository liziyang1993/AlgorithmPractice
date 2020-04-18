import java.util.Arrays;

/**
 * 3 5 7
 */
public class Main {

    public int compareVersion(String version1, String version2) {
        String[] data1 = version1.split("\\.");
        String[] data2 = version2.split("\\.");
        int i = 0;
        while (i < Math.min(data1.length, data2.length)) {
            int v1 = Integer.parseInt(data1[i]);
            int v2 = Integer.parseInt(data2[i]);
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};

    }

}