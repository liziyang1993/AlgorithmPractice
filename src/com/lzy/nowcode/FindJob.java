package com.lzy.nowcode;

import java.util.*;

/**
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。
 * 牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
 * 在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，
 *
 * 每个输入包含一个测试用例。
 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)
 和小伙伴的数量M(M<=100000)。
 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)
 和报酬Pi(Pi<=1000000000)。
 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 保证不存在两项工作的报酬相同。

 3 3
 1 100
 10 1000
 1000000000 1001
 9 10 1000000000
 * */
public class FindJob {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int jobCount = scanner.nextInt();
        int peopleCount = scanner.nextInt();
        Map<Integer,Queue<Integer>> map = new TreeMap<>();
        for(int i = 1;i<=jobCount;i++){
            int hard = scanner.nextInt();
            int salary = scanner.nextInt();
            Queue<Integer> queue = map.getOrDefault(hard,new PriorityQueue<>());
            queue.add(salary);
            map.put(hard,queue);
        }
        int[] people = new int[peopleCount];
        for(int i =0;i<peopleCount;i++){
            people[i] = scanner.nextInt();
        }
        for (int ability:people){
            int last = 0;
            for(int hard:map.keySet()){
                if (hard>ability)break;
                last = hard;
            }
            if (last>0){
                Queue<Integer> queue = map.get(last);
                System.out.println(queue.peek());
            }

        }

    }
}
