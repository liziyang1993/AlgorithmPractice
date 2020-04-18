package com.lzy.interview;

import java.util.concurrent.locks.*;
import java.util.*;
public class ProducerConsumer
{
	private ReentrantLock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	private ArrayList<Object> list = new ArrayList();
	private int maxCount = 100;

	public void put(){
		lock.lock();
		try{
			while (list.size() >= maxCount) notFull.await();
			list.add(new Object());
			System.out.println("add a new Object size="+list.size());
			notEmpty.signalAll();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void get(){
		lock.lock();
		try{
			while (list.size() == 0) notEmpty.await();
			Object object = list.get(list.size()-1);
			list.remove(list.size()-1);
			System.out.println("get a Object "+object.hashCode()+"  size="+list.size());
			notFull.signalAll();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args){
		ProducerConsumer pd = new ProducerConsumer();
		Thread t1 = new Thread(()->{
			while (true)
			{
				pd.put();
			}
		});

		Thread t2 = new Thread(() -> {
			while (true)
			{
				pd.get();
			}
		});
		t1.start();
		t2.start();
	}
}