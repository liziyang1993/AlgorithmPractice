package com.lzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonString {

    public List<String> getLong(String[] data) {
        List<String> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (i==j)continue;
                String s = maxSubstring(data[i],data[j]);
                if (s.length() == max) result.add(s);
                else if (s.length() > max){
                    max = s.length();
                    result.clear();
                    result.add(s);
                }
            }
        }
        return  result;
    }

    public String maxSubstring(String strOne, String strTwo){
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
        String max = "";
        String min = "";
        if(strOne.length() < strTwo.length()){
            max = strTwo;
            min = strOne;
        } else{
            max = strTwo;
            min = strOne;
        }
        String current = "";
        for(int i=0; i<min.length(); i++){
            for(int begin=0, end=min.length()-i; end<=min.length(); begin++, end++){
                current = min.substring(begin, end);
                if(max.contains(current)){
                    return current;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        String[] data ={"alibaba 2019","youku 2020","alibaba 2021"};
        List<String> list =new CommonString().getLong(data);
        for (String s : list){
            System.out.println(s);
        }
        Map<Character,Integer> map;
    }
}
