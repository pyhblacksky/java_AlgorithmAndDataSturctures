package com.my.algs;
import java.util.Iterator;

/*
 * ��ѹջ�ĸĽ����ܹ���̬�ĵ�������Ĵ�С
 * 
 * 
 * 
 * 
 * */

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];	// ջԪ��
	private int N = 0;							// Ԫ������
	public boolean isEmpty() {return N == 0;}
	public int Size() {return N;}
	
	private void resize(int max)
	{
		// ��ջ�ƶ���һ����СΪmax������
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0 ; i < N; i++)
			temp[i] = a[i];
		a = temp;		
	}
	
	public void push(Item item)
	{	// ��Ԫ��ѹ��ջ��
		if( N == a.length)
			resize(2*a.length);
		a[N++] = item;
	}
	
	public Item pop()
	{
		Item item = a[--N];
		a[N] = null;   // �����������
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	
	public Iterator<Item> iterator()
	{
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i = N;
		public boolean hasNext() {return i > 0;}
		public Item next() {return a[--i];}
		public void remove() {}
	}
}
