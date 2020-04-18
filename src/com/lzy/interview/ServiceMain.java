package com.lzy.interview;

import java.util.concurrent.*;
import java.util.*;
public class ServiceMain
{
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(5);
		List<Future<Integer>> list= new ArrayList();
		int sum =0;
		Callable<Integer> callable = new Callable(){
			public Integer call(){
				System.out.println("thread "+Thread.currentThread().getName()+"  is executing");
				return 10;
			}
		};
		try
		{
			for (int i =0;i<10 ;i++ )
			{
				Future<Integer> future = service.submit(callable);
				list.add(future);
			}
			for(int i = 0;i<list.size();i++){
				int x = list.get(i).get();
				sum += x;
			}
			service.shutdown();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("sum="+sum);
	}
}