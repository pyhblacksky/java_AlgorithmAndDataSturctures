package com.my.strings;

/*
 * 	���ڵ��ʲ������ķ��ű�
 * 
 * 
 * */

public class TrieST<Value> {

	private static int R = 256;	//	����
	private Node root;			//	���ʲ������ĸ����
	 
	private static class Node
	{
		private Object val;
		private Node[] next = new Node[R];
	}
	
	//	  �ⲿ���õķ���
	public Value get(String key)
	{
		Node x = get(root, key, 0);
		if(x == null)
			return null;
		return (Value)x.val;
	}
	
	//	������x��Ϊ�������ӵ��ʲ���������key�������ֵ
	private Node get(Node x, String key, int d)
	{
		if(x == null)
			return null;
		if(d == key.length())
			return x;
		char c = key.charAt(d);		//	�ҵ���d���ַ�����Ӧ���ӵ��ʲ�����
		return get(x.next[c], key, d+1);
	}
	
	//	�ⲿ���õķ���
	public void put(String key, Value val)
	{
		root = put(root, key, val, 0);
	}
	
	//	���key��������xΪ�������ӵ��ʲ�����������������������ֵ
	private Node put(Node x, String key, Value val, int d)
	{
		if(x == null)
			return null;
		if(d == key.length())
		{
			x.val = val;
			return x;
		}
		char c = key.charAt(d);		//	�ҵ���d���ַ�����Ӧ���ӵ��ʲ�����
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
		
	}
}
