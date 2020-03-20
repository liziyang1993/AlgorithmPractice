import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public int numDecodings(String s) {
        if(s==null || s.length()==0)return 0;
        char[] array = s.toCharArray();
        int[] dp = new int[s.length()+1];
        int last = array[0]-'0';
        if(last<=0)return 0;
        dp[0]=1;
        for(int i =1;i<array.length;i++){
            int moment = array[i]-'0';
            if(moment>6 || moment<1 || last>2){
                dp[i] = dp[i-1];
            }else {
                dp[i] = dp[i-1]+1;
            }
            last = moment;
        }
        return dp[array.length-1];
    }

    public static void main(String[] args) {
        int[][] data = {
                {1,2},
                {2,1},
                {1,4},
                {3,6},
                {7,3}
        };

        Arrays.sort(data,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for(int[] a : data){
            System.out.println(a[0]+","+a[1]);
        }

    }
}