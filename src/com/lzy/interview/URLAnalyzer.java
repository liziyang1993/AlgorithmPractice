package com.lzy.interview;/*
	ʵ��һ������������һ����׼��url�ַ���������ֵ�����url������get�����Լ�ֵ�ļ��ϣ�����ֵ��ʽ�����Լ���ƣ�����ʹ��url�����⣬����ʹ�ñ��������
*/
import java.util.*;
public class URLAnalyzer
{
	public Map<String,String> analyze(String url){
		Map<String,String> map = new HashMap();
		String param = url.substring(url.indexOf('?')+1);
		String[] paramList = param.split("&");
		for (String s : paramList)
		{
			String[] p = s.split("=");
			if(p.length==2)	map.put(p[0], p[1]);
		}
		return map;
	}

	public static void main(String[] args){
		String url = "http://dingding.com?name=dingding&password=dingtalk";
        Map<String,String> map = new URLAnalyzer().analyze(url);
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
	}

}