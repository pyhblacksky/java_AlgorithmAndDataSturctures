package com.test.demo;

/*
 * 	对于线程类的扩展实现
 * 
 * */

public class DemoTwoThread extends Thread{

	//	由于是继承关系，所以在这个基础上直接运行
	public DemoTwoThread()
	{
		super("Child two");
		System.out.println("Child Thread : " + this);
		start();
	}
	
	//	在Thread类中包含有run()，此处只需要重载其实现即可
	public void run()
	{
		try {
			for(int i = 5; i > 0; i--)
			{
				System.out.println("Child two Thread : " + i);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Child Two Interrupted!");
		}
	}
	
}
