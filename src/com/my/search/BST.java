package com.my.search;

/*
 * ���������ʵ�ֲ���
 * 
 * */

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node
	{
		private Node left;	//	ָ��������������
		private Node right;	//	ָ��������������
		private Value val;	//	ֵ
		private Key key;	//	��
		private int N;		//	�Ըý��Ϊ���������н������
		public Node(Value val, Key key, int N)
		{
			this.N = N;
			this.val = val;
			this.key = key;
		}
	}
	
	//	���ش�С
	private int size(Node x)
	{
		if(x == null)
			return 0;
		else
			return x.N;
	}
	public int size()
	{
		return size(root);
	}
	
	//	���ҷ���ʵ��
	private Value get(Node x, Key key)
	{
		//	����xΪ�����������в��Ҳ�����key��ֵ
		//	��Ϊ�գ�����null
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return get(x.left, key);
		else if(cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}
	public Value get(Key key)
	{
		return get(root, key);
	}
	
	
}
