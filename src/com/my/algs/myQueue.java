package com.my.algs;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 队列数据结构的实现（链表）
 * 
 * 
 * */

public class myQueue<Item> implements Iterable<Item> {
	private class Node
	{
		Item item;
		Node next;
	}
	private Node first;
	private Node end;
	private int N;
	
	public myQueue() {
		// TODO Auto-generated constructor stub
		N = 0;
		first = null;
		end = null;
	}
	
	public boolean isEmpty() {return N == 0;}
	
	public int size() {return N;}
	
	public void enQueue(Item item)
	{
		Node temp = new Node();
		temp.item = item;
		temp.next = null;
		if(isEmpty())
		{
			first = temp;
			temp.next = end;
			end = temp;
		}
		else
		{
			end.next = temp;
			end = temp;
		}
		N++;
	}
	
	//	另一种实现
	/*
	 * 	public void enQueue(Item item)
	{
		Node temp = end;
		end = new Node();	// 新的结点
		end.item = item;
		end.next = null;
		if (isEmpty())	first = end;
		else 			temp.next = end;
		N++;
		
	}
	 * 
	 */
	
	public Item deQueue()
	{
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		N--;
		Item item = first.item;
		first = first.next;
		if(isEmpty())	end = null;
		return item;
	}
	
	// 迭代器
	public class ListIteractor implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext()
		{
			return current != null;
		}
		public void remove() {}
		public Item next()
		{
			if(!hasNext()) return null;
			Item item = current.item;
			current = current.next;
			return item; 
		}
				
	}
	public Iterator<Item> iterator()
	{
		return new ListIteractor();		
	}
	
}
