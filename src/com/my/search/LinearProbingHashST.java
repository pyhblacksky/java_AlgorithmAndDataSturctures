package com.my.search;

import javax.swing.SpringLayout.Constraints;

/*
 * 	基于线性探测法的散列表
 * 	
 * 	使用线性探测解决碰撞冲突	
 * 
 * 
 * */

public class LinearProbingHashST<Key, Value> {
	private int N;			//	符号表中键值对的总数
	private int M = 16;		//	线性探探测表的大小
	private Key[] keys;		//	键
	private Value[] vals;	//	值
	
	public LinearProbingHashST()
	{
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	public LinearProbingHashST(int m)
	{
		keys = (Key[]) new Object[m];
		vals = (Value[]) new Object[m];
	}
	
	//	返回hash值
	private int hash(Key key)
	{
		//	变为无符号数
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	//	插入操作
	public void put(Key key, Value val)
	{
		//	将M加倍,扩大
		if(N >= M/2)
			resize(2*M);
		
		int i = hash(key);
		for(; keys[i] != null; i = (i + 1) % M)
		{
			if(keys[i].equals(key))
			{
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	
	//	查找操作
	public Value get(Key key)
	{
		for(int i = hash(key); keys[i] != null; i = (i + 1) % M)
		{
			if(keys[i].equals(key))
				return vals[i];
		}
		return null;
	}
	
	
	//	调整数组大小,防止长键簇的出现影响效率
	public void resize(int cap)
	{
		LinearProbingHashST<Key, Value> temp;
		temp = new LinearProbingHashST<Key, Value>(cap);
		for(int i = 0; i < M; i++)
		{
			if(keys[i] != null)
				temp.put(keys[i], vals[i]);
		}
		keys = temp.keys;
		vals = temp.vals;
		M = temp.M;
	}
	
	//	确定是否包含
	public boolean contains(Key key)
	{
		if(key == null)
			throw new IllegalArgumentException("argument to contains() is null.");
		return get(key) != null;
	}
	
	//	删除操作
	public void delete(Key key)
	{
		if(!contains(key))
			return;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (i + 1) % M;
		keys[i] = null;
		vals[i] = null;
		
		//	为了让之后的元素可以被查找
		i = (i + 1) % M;
		while(keys[i] != null)
		{
			Key keyToReto = keys[i];
			Value valToReto = vals[i];
			keys[i] = null;
			vals = null;
			N--;
			put(keyToReto, valToReto);
			i = (i + 1) % M;
		}
		N--;
		if(N > 0 && N <= M/8)
			resize(M/2);
	}
}
