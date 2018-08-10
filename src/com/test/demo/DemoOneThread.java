package com.test.demo;

/*
 * 	线程的简单测试
 * 	
 * 	含有Runnable接口，必须实现run方法，另外线程需要使用.start()命令使线程启动
 * */

public class DemoOneThread implements Runnable
{
	Thread t;
	
	public DemoOneThread()
	{
		t = new Thread(this, "Child Thread One.");
		System.out.println(t.getName());
		t.start(); 			//	开始运行线程
	}
	
	public void run()
	{
		try {
			for(int i = 5; i > 0; i--)
			{
				System.out.println("Child one Thread: " + i);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Child One Interrupted : " + e);
		}
		System.out.println("Child one exit!");
	}
}
