package com.test.thread;

/*
 * 	�����ֳɵ� ͬ���;���
 * 
 * */

public class Callme {
	public void call(String msg)
	{
		System.out.print("[" + msg);
		try {
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupted!!");
		}
		System.out.println("]");
	}
}
