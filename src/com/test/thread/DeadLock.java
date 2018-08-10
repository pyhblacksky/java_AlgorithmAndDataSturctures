package com.test.thread;

import java.io.BufferedReader;
import java.io.PrintWriter;

/*
 * ʵ����������
 * */

class A
{
	synchronized void foo(B b)
	{
		System.out.println(Thread.currentThread().getName() + " IN CLASS A.");
		
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		System.out.println("Ready to USE B.last()");
		b.last();
	}
	
	//	synchronized�ǽ��������Ĺؼ�����Ϊ������һ���ܳ���
	synchronized void last()
	{
		System.out.println("This is in A class Last");
	}
}

class B
{
	synchronized void bar(A a)
	{
		System.out.println(Thread.currentThread().getName() + " IN CLASS B");
		
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		System.out.println("Ready to USE A.last()");
		a.last();
	}
	
	//	synchronized�ǽ��������Ĺؼ�����Ϊ������һ���ܳ���
	synchronized void last()
	{
		System.out.println("This is in B class Last");
	}
}

public class DeadLock implements Runnable{
	A a = new A();
	B b = new B();
	
	public DeadLock()
	{
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this, "RaceThead");
		t.start();
		//	������ʼ,a�е�b
		a.foo(b);
		System.out.println("USE a.foo(b)!");
	}
	
	public void run()
	{
		//	b�е�a
		b.bar(a);
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("USE b.bar(a)!");
	}
	
	public static void main(String[] args)
	{
		new DeadLock();
	}
	
}
