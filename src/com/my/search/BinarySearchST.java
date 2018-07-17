package com.my.search;
import com.algs.api.*;
import com.my.algs.myQueue;

/*
 *	二分查找
 *	基于有序数组！
 *	效率比顺序查找快得多
 * */

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N = 0;
	
	//	创建
	public BinarySearchST(int capacity)
	{
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Comparable[capacity];
	}
	
	//	返回大小
	public int size()
	{
		return N;
	}
	
	//	是否为空
	public boolean isEmpty()
	{
		return keys[0] == null;
	}
	
	//	基于有序数组的二分查找（迭代）,本实现的关键操作
	public int rank(Key key)
	{
		int lo = 0;
		int hi = N - 1;
		while(lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0)
				hi = mid - 1;
			else if(cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
	
	//	获取键对应的值
	public Value get(Key key)
	{
		if(isEmpty())
			return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else 
			return null;
	}
	
	//	将键值对存入表中
	public void put(Key key, Value val)
	{
		//	查找键，找到则更新值，否则创建新元素
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
		{
			vals[i] = val;
		}
		//	增加新值空间,数组整体向后移动
		for(int j = N; j > i; j--)
		{
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		//	赋值
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	//	删除指定Key值
	public void delete(Key key)
	{
		int i = rank(key);
		//	删除该元素，数组从删去位置整体向前移动
		for(int j = i; j < N; j++)
		{
			keys[j] = keys[j+1];
			vals[j] = vals[j+1];
		}
		N--;
	}
	
	//	最小键
	public Key min()
	{
		return keys[0];
	}
	
	//	最大键
	public Key max()
	{
		return keys[N-1];
	}
	
	//	删除最小键
	public void deleteMin()
	{
		delete(min());
	}
	
	//	删除最大键
	public void deleteMax()
	{
		delete(max());
	}
	
	//	显示
	public void show()
	{
		for(int i = 0; i < N; i++)
		{
			StdOut.println("Key: " + keys[i] + "  Value: " + vals[i]);
		}
	}
	
	//	返回值所对应的键
	public Key select(int k)
	{
		return keys[k];
	}
	
	//	小于等于key的最大键
	public Key ceiling(Key key)
	{
		int i = rank(key);
		return keys[i];
	}
	
	//	大于等于key的最小键
	public Key floor(Key key)
	{
		int i = rank(key);
		return keys[i];
	}
	
	//	删除并返回键
	public Value deleteAndReturn(Key key)
	{
		int i = rank(key);
		Value temp = vals[i];
		for(int j = i; j < N; j++)
		{
			keys[j] = keys[j+1];
			vals[j] = vals[j+1];
		}
		return temp;
	}
	
	//	键key是否存在于表中
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	//	迭代器
	public Iterable<Key> keys(Key lo, Key hi)
	{
		myQueue<Key> q = new myQueue<Key>();
		for(int i = rank(lo); i < rank(hi); i++)
			q.enQueue(keys[i]);
		if(contains(hi))
			q.enQueue(keys[rank(hi)]);
		return q;
	}
}
