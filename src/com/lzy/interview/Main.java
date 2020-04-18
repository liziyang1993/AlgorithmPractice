package com.lzy.interview;

import java.util.concurrent.locks.*;
public class Main {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	int signal = 1;

	public void m1(){
		lock.lock();
		try{
			while (signal != 1) condition.await();
			System.out.print("a ");
			signal = 2;
			condition.signalAll();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void m2(){
		lock.lock();
		try{
			while(signal !=2 ) condition.await();
			System.out.print("b ");
			signal = 3;
			condition.signalAll();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void m3(){
		lock.lock();
		try{
			while(signal != 3) condition.await();
			System.out.print("c ");
			signal = 1;
			condition.signalAll();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args){
		Main main = new Main();
		Thread t1 = new Thread(() -> {
			while(true){
				main.m1();
			}
		});

		Thread t2 = new Thread(() -> {
			while(true){
				main.m2();
			}
		});

		Thread t3 = new Thread(() -> {
			while(true){
				main.m3();
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}
}