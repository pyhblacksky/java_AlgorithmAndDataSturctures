package com.my.algs;

import java.util.Iterator;

/*
 *	使用双向链表实现双向队列 deque
 * 	存在问题，未能完全实现
 * 
 * */

public class myDeque<Item> implements Iterable<Item> {

	private class Node
	{
		Item item;
		Node pre;
		Node next;
	}
	private int N;
	private Node first;
	private Node end;
	
	public myDeque()
	{
		N = 0;
		first = null;
		end = null;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int Size()
	{
		return N;
	}
	
	public void pushLeft(Item item)
	{
		//if(isEmpty())	first.item = item;
		Node temp = first;
		first = new Node();
		//temp.pre = first;
		first.next = temp;
		first.item = item;
		first.pre = null;
		N++;
	}
	
	public void pushRight(Item item)
	{
		//if(isEmpty())	end.item = item;
		Node temp = end;
		end = new Node();
		//temp.next = end;
		end.item = item;
		end.next = null;
		end.pre = temp;
		N++;
	}
	
	public Item popLeft()
	{
		Item item = first.item;
		N--;
		first = first.pre;
		first.next = null;
		return item;
	}
	
	public Item popRight()
	{
		Item item = end.item;
		N--;
		end = end.next;
		end.pre = null;
		return item;
	}
	
	// 迭代器,存在问题
	private class ListIterator implements Iterator<Item>
	{
		private Node current_first = first;
		private Node current_end = end;
		public boolean hasNext()
		{
			return current_first != null;
		}
		public void remove()
		{}
		public Item next()
		{
			if(current_first != null)
			{	
				Item item = current_first.item;
				current_first = current_first.next;
				return item;
			}
			else if(current_end != null)
			{
				Item item = current_end.item;
				current_end = current_end.pre;
				return item;
			}
			return null;
			
		}
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	
}
