package com.lzy.interview;

public class Remove {
	public String remove(String s1, String s2){
		for (char c : s2.toCharArray() )
		{
			s1 = s1.replaceAll(String.valueOf(c),"");
		}
		return s1;
	}

	public static void main(String[] args){
		String s1="abcabdcceddscesabbc",s2 = "abd";
		System.out.println(new Remove().remove(s1,s2));
	}
}