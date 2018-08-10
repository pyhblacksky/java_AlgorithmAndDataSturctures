package com.test.thread;

/*
 * 	�����̵߳ľ�����ͬ��
 * 
 * */

public class Caller implements Runnable {
	public Callme my;
	public String s;
	public Thread t;
	
	public Caller(Callme ob, String msg)
	{
		t = new Thread(this);
		my = ob;
		s = msg;
		t.start();
	}

	//	��ʱ���໥��ͻ��	��Ҫsynchronizedʵ��ͬ��
	/*public void run()
	{
		my.call(s);
	}
	*/
	
	/*
	 * ��һ���߳���һ��ͬ�������ڲ���������ͼ���ø÷�����������ͬ����������ͬʵ���������̱߳���ȴ�
	 * ͬ���Ĺؼ��ṇ̀ܳ��ܳ���һ�������ռ�����Ķ��󣬻�ƻ����塣�ڸ�����ʱ�䣬����һ���߳̿��Ի�ù̡ܳ�
	 * */
	//	ʹ��synchronized,	��˳����ã������ͻ��
	public void run()
	{
		synchronized(my)
		{
			my.call(s);
		}
	}
	
	//	��ȱ��
	/*
	public synchronized void run()
	{
		my.call(s);
	}
	*/
}
