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
		public Node(Key key, Value val, int N)
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
	
	//	ʹ�õݹ���ʵ��
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
	
	//	ʹ�õݹ���ʵ��
	//	��������������򷽷���ʵ��
	private Node put(Node x, Key key, Value val)
	{
		//	��key������x���������У����������ֵ
		//	������ݴ�С��key��valΪ��ֵ�� ����½�㵽������
		if(x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			x.left = put(x.left, key, val);
		else if(cmp > 0)
			x.right = put(x.right, key, val);
		else	//	����ͬ������ֵ
			x.val = val;
		//	���һ�β�������������+1
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
	}
	
	//	��С��
	public Key min()
	{
		Node x = root;
		if(x == null)
			return null;
		while(x != null)
		{
			if(x.left == null)
				break;
			x = x.left;
		}
		return x.key;
	}
	
	//	����
	public Key max()
	{
		Node x = root;
		if(x == null)
			return null;
		while(x != null)
		{
			if(x.right == null)
				break;
			x = x.right;
		}
		return x.key;
		
	}
	
	//	С�ڵ���key������
	public Key ceiling(Key key)
	{
		Node x = ceiling(root, key);
		if(x == null)
			return null;
		return x.key;
	}
	private Node ceiling(Node x, Key key)
	{
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)
			return x;
		if(cmp > 0)
			return ceiling(x.right, key);
		Node temp = x.left;
		if(temp != null)
			return temp;
		else
			return x;
	}
	
	//	���ڵ���key����С��
	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if(x == null)
			return null;
		return x.key;
	}
	private Node floor(Node x, Key key)
	{
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)
			return x;
		if(cmp < 0)
			return floor(x.left, key);
		Node temp = x.right;
		if(temp != null)
			return temp;
		else
			return x;
	}
	
	/*
	 * �˴��Ƿǵݹ�ʵ�ֶ��������
	 * ʵ��Ӧ�����Էǵݹ��Ϊ��
	 * */
	//	���벢����,�ǵݹ�			��δʵ��
	public void NoRecursivePut(Key key, Value val)
	{
		Node x = root;
		if(x == null)
		{
			x = new Node(key, val, 1);
			root = x;
			return;
		}
		while(x != null)
		{
			int cmp = key.compareTo(x.key);
			
		}
		x.N = size(x.left) + size(x.right) + 1;
	}
	
	//	���Ҳ�����ֵ���ǵݹ�
	public Value NoRecursiveGet(Key key)
	{
		Node x = root;
		while(x != null)
		{
			int cmp = key.compareTo(x.key);
			if(cmp == 0)
				return x.val;
			else if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
		}
		return null;
	}
	
	/*************************************************/
}
