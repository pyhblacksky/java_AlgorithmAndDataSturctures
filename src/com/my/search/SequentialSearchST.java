package com.my.search;
import com.algs.api.*;

/*
 * 顺序查找（基于无序链表）
 * 
 * */

public class SequentialSearchST<Key, Value> {

	//	使用链表， 定义链表
	private class Node
	{
		//	链表结点的定义
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	private Node first;	//	链表首结点 	
	
	private int N = 0;	//	用于计数
	
	//	将键值对存入表中（若值为空则将键key从表中删除）
	public void put(Key key, Value val)
	{
		//	查找给定的键，找到则更新其值，否则在表中新建结点
		for(Node x = first; x != null; x=x.next)
		{
			//	若命中，则更新
			if(key.equals(x.key))
			{
				x.val = val;
				return;
			}
		}
		//	没有，新建结点
		first = new Node(key, val, first);
	}
	
	//	获取键key对应的值（若key不存在则返回空）
	public Value get(Key key)
	{
		//	查找给定的键，返回关联的值
		for(Node x = first; x != null; x = x.next)
		{
			if(key.equals(x.key))
			{
				return x.val;	//	命中，成功找到
			}
		}
		return null;	//	未命中，返回null
	}
	
	//	从表中删去key
	public void delete(Key key)
	{
		put(key, null);
	}
	
	//	键key是否存在于表中
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	//	表是否为空
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	//	表中的键值对数量
	public int size()
	{
		int N = 0;
		for(Node x = first; x != null; x = x.next)
		{
			N++;
		}
		return N;
	}
	
	//	最小的键
	public Key min()
	{
		return null;
	}
	
	//	最大的键
	public Key max()
	{
		return null;
	}
	
	//	小于等于key的最大键
	public Key floor(Key key)
	{
		return null;
	}
	
	//	大于等于key的最小键
	public Key ceiling(Key key)
	{
		return null;
	}
	
	//	小于key的键数量
	public int rank(Key key)
	{
		return 0;
	}
	
	//	排名为k的键
	public Key select(int k)
	{
		return null;
	}
	
	//	删除最小的键
	public void deleteMin()
	{
		delete(min());
	}
	
	//	删除最大的键
	public void deleteMax()
	{
		delete(max());
	}
	
	//	[lo..hi]之间键的数量
	public int size(Key lo, Key hi)
	{
		int N = 0;
		for(Node x = first; x != null; x = x.next)
		{
			if(lo.equals(x.key))
			{
				while(!hi.equals(x.key))
				{
					x = x.next;
					N++;
				}
			}
		}
		return N;
	}
	
	//	[lo..hi]之间的所有键，已排序
	public Iterable<Key> keys(Key lo, Key hi)
	{
		return null;
	}
	
	//	表中所有键的集合，已排序
	public Iterable<Key> keys()
	{
		return keys(min(), max());
	}
	
	//	显示函数段
	public void show()
	{
		for(Node x = first; x != null; x = x.next)
		{
			StdOut.print("key:"+x.key+"  value:"+x.val);
			StdOut.println();
		}
		StdOut.println();
	}
}
