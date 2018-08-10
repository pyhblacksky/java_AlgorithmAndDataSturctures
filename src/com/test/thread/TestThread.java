package com.test.thread;
import java.lang.*;


public class TestThread {
	
	/*
	public static void main(String[] args)
	{
		//	运行线程1，开始线程调用
		DemoOneThread ob1 = new DemoOneThread();
		//	运行线程2，开始线程调用
		DemoTwoThread ob2 = new DemoTwoThread();
		
		try {
			for(int i = 5; i > 0; i--)
			{
				//	join(),等待ob1.t和ob2线程结束后执行该线程
				ob1.t.join();
				ob2.join();
				System.out.println("Main Thread : " + i);
				//Thread.sleep(1000);		//	必须确保主线程最后结束
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Main interrupted : " + e);
		}
		System.out.println("Main Thread exit!");
	}
	
	*/
	
	public static void main(String[] args)
	{
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "Hell");
		Caller ob2 = new Caller(target, "getsd");
		Caller ob3 = new Caller(target, "wdshd");
		
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println("Main Interrupted!!");
		}
		
	}
	
}

