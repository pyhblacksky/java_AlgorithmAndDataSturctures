package com.my.search;

/*
 * 红黑树（红黑二叉查找树）的实现
 * 2-3树和普通二叉树查找树的结合，相比2-3树易于实现
 * 将红链画平就是一颗平衡的二叉树
 * 
 * 普通二叉查找树的优点：简洁高效的查找方法
 * 2-3树的优点：高效的平衡插入算法
 * 
 * 等价定义：
 * 1.	红链接均为左链接
 * 2.	没有任何一个结点同时和两条红链相连
 * 3.	该树识完美黑色平衡的，即任意空链接到根结点的路径上的黑链接数量相同
 * 
 * */

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	/***************************************/
	//	红黑树关键实现
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node
	{
		Node left, right;	//	结点的左右子树
		Key key;			//	键
		Value val;			//	相关联的值
		boolean color;		//	由其父节点指向它的链接颜色!!
		int N;				//	这棵子树中的结点总数
		
		Node(Key key, Value val, int N, boolean color)
		{
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x)
	{
		if(x == null)
			return false;
		return x.color == RED;
	}
	
	//	在红黑树种，不允许出现红色右链接和两条连续的红链接，所以需要旋转
	//	旋转可以保持红黑树的两个性质：有序性和完美平衡性
	//	左旋转，将红色右链接转为左,重置父节点（或根结点）
	public Node rotateLeft(Node h)
	{
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	//	右旋转
	public Node rotateRight(Node h)
	{
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;		
	}
	
	//	向一颗双键树（3-结点）中插入新建，即有连续的红链接，需要将红链接全变为黑链接,然后源结点向上是红链接
	//	用flipColors方法来转换颜色
	public void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	/***************************************/
	
	private Node root;
	
	//	返回结点数
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
	
}
