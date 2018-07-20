package com.my.search;

/*
 * 	基于 拉链法 的散列表
 * 	
 * 	用于碰撞处理：处理两个或多个键的散列值相同的情况
 * 	原理：将大小为M的数组中每个元素指向一条链表，链表中的每个结点都存储了散列值为该元素的索引的键值对。
 * 		选择足够大的M，使得所有链表都尽可能短，以保证高效的查找
 * 
 * */

public class SeparateChainingHashST<Key, Value> {
	private int N;	//	键值对总数
	private int M;	//	散列表的大小
	private SequentialSearchST<Key, Value>[] st;
	
	//	构造函数
	public SeparateChainingHashST(int M)
	{
		//	创建M条链表
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		
		for(int i = 0; i < M; i++)
			st[i] = new SequentialSearchST<Key, Value>();
	}
	private SeparateChainingHashST()
	{
		//	默认构造函数使用997条链表
		this(997);
	}
	
	//	散列值计算
	public int hash(Key key)
	{
		//	将符号位屏蔽
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	//	查找
	public Value get(Key key)
	{
		return (Value) st[hash(key)].get(key);
	}
	
	//	插入
	public void put(Key key, Value val)
	{
		if(key == null)
			throw new IllegalArgumentException("first argument to put() is null.");
		if(val == null)
		{
			delete(key);
			return;
		}
		
		int i = hash(key);
		if(!st[i].contains(key))
			N++;
		st[i].put(key, val);
	}
	
	//	返回大小
	public int size()
	{
		return N;
	}
	
	//	删除操作
	public void delete(Key key)
	{
		if(key == null)
			throw new IllegalArgumentException("argument to delete() is null.");
		
		int i = hash(key);
		if(st[i].contains(key))
			N--;
		st[i].delete(key);
	}
}
