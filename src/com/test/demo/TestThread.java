package com.test.demo;
import java.lang.*;


public class TestThread {
	
	public static void main(String[] args)
	{
		//	�����߳�1
		new DemoOneThread();
		//	�����߳�2
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

