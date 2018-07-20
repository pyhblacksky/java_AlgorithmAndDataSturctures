package com.my.search;

/*
 * 	���� ������ ��ɢ�б�
 * 	
 * 	������ײ��������������������ɢ��ֵ��ͬ�����
 * 	ԭ������СΪM��������ÿ��Ԫ��ָ��һ�����������е�ÿ����㶼�洢��ɢ��ֵΪ��Ԫ�ص������ļ�ֵ�ԡ�
 * 		ѡ���㹻���M��ʹ���������������̣ܶ��Ա�֤��Ч�Ĳ���
 * 
 * */

public class SeparateChainingHashST<Key, Value> {
	private int N;	//	��ֵ������
	private int M;	//	ɢ�б�Ĵ�С
	private SequentialSearchST<Key, Value>[] st;
	
	//	���캯��
	public SeparateChainingHashST(int M)
	{
		//	����M������
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		
		for(int i = 0; i < M; i++)
			st[i] = new SequentialSearchST<Key, Value>();
	}
	private SeparateChainingHashST()
	{
		//	Ĭ�Ϲ��캯��ʹ��997������
		this(997);
	}
	
	//	ɢ��ֵ����
	public int hash(Key key)
	{
		//	������λ����
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	//	����
	public Value get(Key key)
	{
		return (Value) st[hash(key)].get(key);
	}
	
	//	����
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
	
	//	���ش�С
	public int size()
	{
		return N;
	}
	
	//	ɾ������
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
