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
		public Node(Key key, Value val, int N)
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
	
	//	使用递归来实现
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
	
	//	使用递归来实现
	//	插入操作，且排序方法的实现
	private Node put(Node x, Key key, Value val)
	{
		//	若key存在于x的子树当中，则更新它的值
		//	否则根据大小以key和val为键值对 添加新结点到子树中
		if(x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			x.left = put(x.left, key, val);
		else if(cmp > 0)
			x.right = put(x.right, key, val);
		else	//	键相同，更新值
			x.val = val;
		//	完成一次操作，结点计数器+1
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
	}
	
	/*
	 * 此处是非递归实现二叉查找树
	 * 实际应用中以非递归的为主
	 * */
	//	插入并排序,非递归
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
			if(x == null)
				x = new Node(key, val, 1);
			int cmp = key.compareTo(x.key);
			
		}
		x.N = size(x.left) + size(x.right) + 1;
	}
	
	//	查找并返回值，非递归
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
