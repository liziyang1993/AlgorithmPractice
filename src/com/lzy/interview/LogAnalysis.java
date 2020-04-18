package com.lzy.interview;

import java.io.*;
import java.util.*;

public class LogAnalysis{
	public Set<String> analysis(String fileName){
		List<String> result = new ArrayList();
		TreeSet<String> set = new TreeSet<String>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String log = reader.readLine();
			while (log != null && !log.equals(""))
			{
				if(log.contains("error") || log.contains("ERROR")){
					set.add(log);
				}
				log = reader.readLine();
			}
			reader.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return set;
	}

	public static void main(String[] args){
		Set<String> set = new LogAnalysis().analysis("D:\\log.log");
		for (String s : set)
		{
			System.out.println(s);
		}
	}
} 