package com.my.search;
import com.algs.api.*;
import com.my.sort.*;

/*
 * 	简单的有序泛型符号表
 * 	用数组实现吗？
<<<<<<< HEAD
 * 
 * 	这里只是一些实现所需要的api
 * 	可以基于此模板自行创建
=======
>>>>>>> refs/remotes/origin/master
 * */

public class SimpleST<Key extends Comparable<Key>, Value> {
	
	private int N = 0;
	private Comparable<Key>[] ST;
	
	//	创建一张有序符号表
	public SimpleST(int n)
	{
		ST = new Comparable[n];
		Quick.sort(ST);
	}
	
	//	将键值对存入表中（若值为空则将键key从表中删除）
	public void put(Key key, Value value)
	{
		ST[(int) value] = key;
		N++;
	}
	
	//	获取键key对应的值（若key不存在则返回空）
	public Value get(Key key)
	{
		for(int i = 0; i < N; i++)
		{
			if(ST[i].equals(key))
				return null;//返回什么?
		}
		return null;
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
		if(hi.compareTo(lo) < 0)
			return 0;
		else if(contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);
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
	
	
}
