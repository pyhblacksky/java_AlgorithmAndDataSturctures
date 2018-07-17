package com.my.search;
import com.algs.api.*;
import com.my.algs.myQueue;

/*
 *	���ֲ���
 *	�����������飡
 *	Ч�ʱ�˳����ҿ�ö�
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
		return keys[0] == null;
	}
	
	//	������������Ķ��ֲ��ң�������,��ʵ�ֵĹؼ�����
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
		int i = rank(key);
		//	ɾ����Ԫ�أ������ɾȥλ��������ǰ�ƶ�
		for(int j = i; j < N; j++)
		{
			keys[j] = keys[j+1];
			vals[j] = vals[j+1];
		}
		N--;
	}
	
	//	��С��
	public Key min()
	{
		return keys[0];
	}
	
	//	����
	public Key max()
	{
		return keys[N-1];
	}
	
	//	ɾ����С��
	public void deleteMin()
	{
		delete(min());
	}
	
	//	ɾ������
	public void deleteMax()
	{
		delete(max());
	}
	
	//	��ʾ
	public void show()
	{
		for(int i = 0; i < N; i++)
		{
			StdOut.println("Key: " + keys[i] + "  Value: " + vals[i]);
		}
	}
	
	//	����ֵ����Ӧ�ļ�
	public Key select(int k)
	{
		return keys[k];
	}
	
	//	С�ڵ���key������
	public Key ceiling(Key key)
	{
		int i = rank(key);
		return keys[i];
	}
	
	//	���ڵ���key����С��
	public Key floor(Key key)
	{
		int i = rank(key);
		return keys[i];
	}
	
	//	ɾ�������ؼ�
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
	
	//	��key�Ƿ�����ڱ���
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	//	������
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
