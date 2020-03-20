public class ByteDance {

    public int number(String s) {
        String[] arr = s.split("万");
        if (arr.length < 2) return analysis(arr[0]);
        return analysis(arr[0]) * 10000 + analysis(arr[1]);
    }

    int analysis(String s) {
        int unit = find(s.charAt(s.length() - 1));
        int ten = s.indexOf("十") > 0 ? find(s.charAt(s.indexOf("十") - 1)) : 0;
        int hundred = s.indexOf("百") > 0 ? find(s.charAt(s.indexOf("百") - 1)) : 0;
        int thousand = s.indexOf("千") > 0 ? find(s.charAt(s.indexOf("千") - 1)) : 0;
        return thousand * 1000 + hundred * 100 + ten * 10 + unit;
    }

    int find(char c) {
        char[] arr = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
        for (int i = 0; i < 10; i++) {
            if (c == arr[i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "二万一千二百二十一";
        System.out.println(new ByteDance().number(s));
    }
}
