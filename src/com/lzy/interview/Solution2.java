package com.lzy.interview;

import java.util.*;
public class Solution2 {
	
	List<Object> list = new ArrayList<>();
	int maxCount = 100;

	public synchronized void put(){
		try{
			while (list.size() >= 100) this.wait();
			list.add(new Object());
			System.out.println("add new Object siez=" + list.size());
			this.notifyAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public synchronized void take(){
		try{
			while (list.size() == 0) this.wait();
			Object object = list.get(list.size()-1);
			list.remove(list.size()-1);
			System.out.println("remove Object"+ object.hashCode() +" siez=====" + list.size());
			this.notifyAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}


	public static void main(String[] args){
		Solution2 solution = new Solution2();
		Thread t1 = new Thread(() ->{
			while(true) solution.put();
		});

		Thread t2 = new Thread(() -> {
			while(true) solution.take();
		});

		Thread t3 = new Thread(() ->{
			while(true) solution.put();
		});

		Thread t4 = new Thread(() -> {
			while(true) solution.take();
		});

		t1.start();
		t2.start();
		t3.start();
		t2.start();
	}
}