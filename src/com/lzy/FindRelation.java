package com.lzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRelation {

    public List<String> findRelation(String[][] relation,String target){
        Map<String,String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String[] str : relation){
            map.put(str[1],str[0]);
        }
        String begin = target;
        while(map.containsKey(target)){
            String value = map.get(target);
            if(result.contains(value) || value.equals(begin)) {
                //判断依赖关系中是否出现环，如果出现环则跳出
                break;
            }
            result.add(value);
            target = map.get(target);
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] relation = {
                {"A","B"},
                {"B","C"},
                {"C","D"},
                {"E","F"}
        };
        List<String> list = new FindRelation().findRelation(relation,"F");
        for(String str:list){
            System.out.print(str+" ");
        }
    }
}
