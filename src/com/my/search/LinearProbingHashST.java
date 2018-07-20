package com.my.search;

import javax.swing.SpringLayout.Constraints;

/*
 * 	��������̽�ⷨ��ɢ�б�
 * 	
 * 	ʹ������̽������ײ��ͻ	
 * 
 * 
 * */

public class LinearProbingHashST<Key, Value> {
	private int N;			//	���ű��м�ֵ�Ե�����
	private int M = 16;		//	����̽̽���Ĵ�С
	private Key[] keys;		//	��
	private Value[] vals;	//	ֵ
	
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
	
	//	����hashֵ
	private int hash(Key key)
	{
		//	��Ϊ�޷�����
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	//	�������
	public void put(Key key, Value val)
	{
		//	��M�ӱ�,����
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
	
	
	//	���Ҳ���
	public Value get(Key key)
	{
		for(int i = hash(key); keys[i] != null; i = (i + 1) % M)
		{
			if(keys[i].equals(key))
				return vals[i];
		}
		return null;
	}
	
	
	//	���������С,��ֹ�����صĳ���Ӱ��Ч��
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
	
	//	ȷ���Ƿ����
	public boolean contains(Key key)
	{
		if(key == null)
			throw new IllegalArgumentException("argument to contains() is null.");
		return get(key) != null;
	}
	
	//	ɾ������
	public void delete(Key key)
	{
		if(!contains(key))
			return;
		int i = hash(key);
		while(!key.equals(keys[i]))
			i = (i + 1) % M;
		keys[i] = null;
		vals[i] = null;
		
		//	Ϊ����֮���Ԫ�ؿ��Ա�����
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
