package com.test.thread;

/*
 * 	测试线程的竞争和同步
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

	//	此时会相互冲突，	需要synchronized实现同步
	/*public void run()
	{
		my.call(s);
	}
	*/
	
	/*
	 * 当一个线程在一个同步方法内部，所有试图调用该方法（或其他同步方法）的同实例的其他线程必须等待
	 * 同步的关键是管程，管程是一个互斥独占锁定的对象，或称互斥体。在给定的时间，仅有一个线程可以获得管程。
	 * */
	//	使用synchronized,	按顺序调用，解决冲突：
	public void run()
	{
		synchronized(my)
		{
			my.call(s);
		}
	}
	
	//	有缺陷
	/*
	public synchronized void run()
	{
		my.call(s);
	}
	*/
}
