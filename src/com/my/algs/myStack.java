package com.my.algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 用链表实现下压栈
 * 
 * 
 * */


public class myStack<Item> implements Iterable<Item> {
	private int N ;
	private class Node
	{
		Item item;
		Node next;
	}
	private Node first; // 栈顶
	
	public myStack() {
		// TODO Auto-generated constructor stub
		N = 0;
		first = null;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public int Size()
	{
		return N;
	}
	
	public void push(Item item)
	{
		Node temp = new Node();
		temp.item = item;
		if(isEmpty())
			first = temp;
		else
		{	
			temp.next = first;
			first = temp;
		}
		N++;
	}
	
	/*
	 * 另一种实现
	 * 	public void push(Item item)
	{
		Node temp = first;
		first = new Node();
		first.item = item;
		first.next = temp;
		N++;
	}
	 * 
	 * */
	
	public Item pop()
	{
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	// 返回最近添加的元素
	public Item peek()
	{
		if(isEmpty())	return null;
		Item item = first.item;
		return item;
	}
	
	// 迭代器
	 public Iterator<Item> iterator() 
	 {
	        return new ListIterator(first);
	 }
	private class ListIterator implements Iterator<Item>
	{
		private Node current;
		public ListIterator(Node first) {
			// TODO Auto-generated constructor stub
			current = first;
		}
		public boolean hasNext()
		{
			return current != null;
		}
		public void remove() {}
		public Item next()
		{
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
}
