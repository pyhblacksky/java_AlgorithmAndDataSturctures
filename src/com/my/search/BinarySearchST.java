package com.my.search;
import com.algs.api.*;

/*
 *	���ֲ���
 *	�����������飡
 *
 * */

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N = 0;
	
	//	����
	public BinarySearchST(int capacity)
	{
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Comparable[capacity];
	}
	
	//	���ش�С
	public int size()
	{
		return N;
	}
	
	//	�Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	//	������������Ķ��ֲ��ң�������
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
	
	//	��ȡ����Ӧ��ֵ
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
	
	//	����ֵ�Դ������
	public void put(Key key, Value val)
	{
		//	���Ҽ����ҵ������ֵ�����򴴽���Ԫ��
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
		{
			vals[i] = val;
		}
		//	������ֵ�ռ�,������������ƶ�
		for(int j = N; j > i; j--)
		{
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		//	��ֵ
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	//	ɾ��ָ��Keyֵ
	public void delete(Key key)
	{
		
	}
}
