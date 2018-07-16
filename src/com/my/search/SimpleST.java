package com.my.search;
import com.algs.api.*;
import com.my.sort.*;

/*
 * 	�򵥵������ͷ��ű�
 * 	������ʵ����
<<<<<<< HEAD
 * 
 * 	����ֻ��һЩʵ������Ҫ��api
 * 	���Ի��ڴ�ģ�����д���
=======
>>>>>>> refs/remotes/origin/master
 * */

public class SimpleST<Key extends Comparable<Key>, Value> {
	
	private int N = 0;
	private Comparable<Key>[] ST;
	
	//	����һ��������ű�
	public SimpleST(int n)
	{
		ST = new Comparable[n];
		Quick.sort(ST);
	}
	
	//	����ֵ�Դ�����У���ֵΪ���򽫼�key�ӱ���ɾ����
	public void put(Key key, Value value)
	{
		ST[(int) value] = key;
		N++;
	}
	
	//	��ȡ��key��Ӧ��ֵ����key�������򷵻ؿգ�
	public Value get(Key key)
	{
		for(int i = 0; i < N; i++)
		{
			if(ST[i].equals(key))
				return null;//����ʲô?
		}
		return null;
	}
	
	//	�ӱ���ɾȥkey
	public void delete(Key key)
	{
		put(key, null);
	}
	
	//	��key�Ƿ�����ڱ���
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	//	���Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	//	���еļ�ֵ������
	public int size()
	{
		return N;
	}
	
	//	��С�ļ�
	public Key min()
	{
		return null;
	}
	
	//	���ļ�
	public Key max()
	{
		return null;
	}
	
	//	С�ڵ���key������
	public Key floor(Key key)
	{
		return null;
	}
	
	//	���ڵ���key����С��
	public Key ceiling(Key key)
	{
		return null;
	}
	
	//	С��key�ļ�����
	public int rank(Key key)
	{
		return 0;
	}
	
	//	����Ϊk�ļ�
	public Key select(int k)
	{
		return null;
	}
	
	//	ɾ����С�ļ�
	public void deleteMin()
	{
		delete(min());
	}
	
	//	ɾ�����ļ�
	public void deleteMax()
	{
		delete(max());
	}
	
	//	[lo..hi]֮���������
	public int size(Key lo, Key hi)
	{
		if(hi.compareTo(lo) < 0)
			return 0;
		else if(contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);
	}
	
	//	[lo..hi]֮������м���������
	public Iterable<Key> keys(Key lo, Key hi)
	{
		return null;
	}
	
	//	�������м��ļ��ϣ�������
	public Iterable<Key> keys()
	{
		return keys(min(), max());
	}
	
	
}
