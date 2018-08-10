package com.test.thread;

/*
 * 	测试现成的 同步和竞争
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
