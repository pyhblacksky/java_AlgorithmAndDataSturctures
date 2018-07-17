package com.my.search;

/*
 * 二叉查找树实现查找
 * 
 * */

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node
	{
		private Node left;	//	指向左子树的链接
		private Node right;	//	指向右子树的链接
		private Value val;	//	值
		private Key key;	//	键
		private int N;		//	以该结点为根的子树中结点总数
		public Node(Value val, Key key, int N)
		{
			this.N = N;
			this.val = val;
			this.key = key;
		}
	}
	
	//	返回大小
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
	
	//	查找方法实现
	private Value get(Node x, Key key)
	{
		//	在以x为根结点的子树中查找并返回key的值
		//	若为空，返回null
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
