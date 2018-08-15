package com.my.algs;
import java.util.Iterator;

/**
 * 背包数据结构的实现
 * 
 * 
 * */

public class myBag<Item> implements Iterable<Item> {

	private class Node
	{
		Node next;
		Item item;
	}
	private Node first;
	private int N;
	
	public myBag() {
		// TODO Auto-generated constructor stub
		first = null;
		N = 0;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public int Size()
	{
		return N;
	}
	
	public void add(Item item)
	{
		Node temp = first;
		first = new Node();
		first.item = item;
		first.next = temp;
		N++;
	}
	
	public class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext()
		{
			return current != null;
		}
		public void remove() {}
		public Item next()
		{
			if(!hasNext())	return null;
			Item item = current.item;
			current = current.next;
			return item;
		}

	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

}
