package com.test.demo;
import java.lang.*;


public class TestThread {
	
	public static void main(String[] args)
	{
		//	运行线程1
		new DemoOneThread();
		//	运行线程2
		new DemoTwoThread();
		
		try {
			for(int i = 5; i > 0; i--)
			{
				System.out.println("Main Thread : " + i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Main interrupted : " + e);
		}
		System.out.println("Main Thread exit!");
	}
	
}

