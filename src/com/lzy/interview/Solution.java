package com.lzy.interview;

import java.util.concurrent.locks.*;
import java.util.*;

public class Solution {

	Lock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();
	List<Object> list = new ArrayList<>();
	int maxCount = 100;

	public void put(){
		lock.lock();
		try{
			while (list.size() >= maxCount) notFull.await();
			list.add(new Object());
			System.out.println("add new Object.....size="+list.size());
			notEmpty.signalAll();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void take(){
		lock.lock();
		try{
			while(list.size() == 0) notEmpty.await();
			Object object = list.get(list.size()-1);
			list.remove(list.size()-1);
			System.out.println("remove object "+object.hashCode()+" size="+list.size());
			notFull.signalAll();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}


	public static void main(String[] args){
		Solution solution = new Solution();
		Thread t1 = new Thread(() ->{
			while(true) solution.put();
		});

		Thread t2 = new Thread(() -> {
			while(true) solution.take();
		});
		t1.start();
		t2.start();
	}
}