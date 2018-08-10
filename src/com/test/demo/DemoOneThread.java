package com.test.demo;

/*
 * 	�̵߳ļ򵥲���
 * 	
 * 	����Runnable�ӿڣ�����ʵ��run�����������߳���Ҫʹ��.start()����ʹ�߳�����
 * */

public class DemoOneThread implements Runnable
{
	Thread t;
	
	public DemoOneThread()
	{
		t = new Thread(this, "Child Thread One.");
		System.out.println(t.getName());
		t.start(); 			//	��ʼ�����߳�
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
