package com.test.thread;
import java.lang.*;


public class TestThread {
	
	/*
	public static void main(String[] args)
	{
		//	�����߳�1����ʼ�̵߳���
		DemoOneThread ob1 = new DemoOneThread();
		//	�����߳�2����ʼ�̵߳���
		DemoTwoThread ob2 = new DemoTwoThread();
		
		try {
			for(int i = 5; i > 0; i--)
			{
				//	join(),�ȴ�ob1.t��ob2�߳̽�����ִ�и��߳�
				ob1.t.join();
				ob2.join();
				System.out.println("Main Thread : " + i);
				//Thread.sleep(1000);		//	����ȷ�����߳�������
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

