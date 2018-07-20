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
		st[hash(key)].put(key, val);
	}
	
}
