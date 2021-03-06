package com.my.algs;
import java.util.Iterator;

/*
 * 下压栈的改进，能够动态的调整数组的大小
 * 
 * 
 * 
 * 
 * */

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];	// 栈元素
	private int N = 0;							// 元素数量
	public boolean isEmpty() {return N == 0;}
	public int Size() {return N;}
	
	private void resize(int max)
	{
		// 将栈移动到一个大小为max的数组
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0 ; i < N; i++)
			temp[i] = a[i];
		a = temp;		
	}
	
	public void push(Item item)
	{	// 将元素压入栈顶
		if( N == a.length)
			resize(2*a.length);
		a[N++] = item;
	}
	
	public Item pop()
	{
		Item item = a[--N];
		a[N] = null;   // 避免对象游离
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
