package com.lzy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LogAnalysis {

    public List<String> anylyze(String fileName) {
        List<String> result = new ArrayList<>();
        TreeSet<String> set = new TreeSet();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String log = reader.readLine();
            while (log != null && !log.equals("")) {
                String copy = log;
                if (log.contains("error")) {
                    set.add(copy);
                }
                log = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String log : set) {
            result.add(log);
        }
        return result;
    }

    public static void main(String[] args){
       LogAnalysis logAnalysis = new LogAnalysis();
       List<String> list = logAnalysis.anylyze("D:\\log.log");
       for (String s : list){
           System.out.println(s);
       }
    }
}
