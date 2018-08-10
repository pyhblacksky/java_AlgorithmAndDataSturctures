package com.test.thread;

/*
 * 	�����߳������չʵ��
 * 	�������߳�
 * 	���뱻���ص���run()����
 * */

public class DemoTwoThread extends Thread{

	//	�����Ǽ̳й�ϵ�����������������ֱ������
	public DemoTwoThread()
	{
		super("Child two");
		System.out.println("Child Thread Two : " + this + " ���ȼ���" + getPriority());
		start();
	}
	
	//	��Thread���а�����run()���˴�ֻ��Ҫ������ʵ�ּ���
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
		System.out.println("Child Two Exit!");
	}
	
}
