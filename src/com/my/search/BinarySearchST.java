package com.my.search;
import com.algs.api.*;

/*
 *	二分查找
 *	基于有序数组！
 *
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
		return N == 0;
	}
	
	//	基于有序数组的二分查找（迭代）
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
		
	}
}
