package com.my.search;

import com.algs.api.StdOut;
import com.my.algs.myQueue;

/*
 * 二叉查找树实现查找
 * 
 * 二叉查找树：左小右大，左子树小于根结点，右子树大于根结点
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
	
	//	最小键
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
	//	返回最小结点
	private Node min(Node x)
	{
		if(x.left == null)
			return x;
		return min(x.left);
	}
	
	//	最大键
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
	//	返回最大结点
	private Node max(Node x)
	{
		if(x.right == null)
			return x;
		return max(x.right);
	}
	
	//	小于等于key的最大键
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
	
	//	大于等于key的最小键
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
	
	//	排名rank，
	public int rank(Key key)
	{
		return rank(root, key);
	}
	//	返回以x为根结点的子树中小于x.key的键的数量
	private int rank(Node x, Key key)
	{
		if(x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return rank(x.left, key);
		else if(cmp > 0)		//	rank(x.right, key) 为了返回所有的比key小的左子树数目
			return 1 + size(x.left) + rank(x.right, key);
		else //	比key小的键数量
			return size(x.left);
	}
	
	//	找出排名为k的键
	public Key select(int k)
	{
		return select(root, k).key;
	}
	private Node select(Node x, int k)
	{
		//	返回排名为k的结点
		if(x == null)
			return null;
		int t = size(x.left);
		if(t > k)	//	全比k小
			return select(x.left, k);
		if(t < k)	//	k比较大 需要减小k值进行遍历
			return select(x.right, k-t-1);
		else
			return x;
	}
	
	//	删除最小值，不断遍历，直到最左结点
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	private Node deleteMin(Node x)
	{
		//	左子树已为空，仅剩下右子树
		if(x.left == null)
			return x.right;	//	返回右子树的连接
		x.left = deleteMin(x.left);	// 不断递归遍历
		x.N = size(x.left) + size(x.right) + 1;	//	需要改变N值
		return x;
	}
	
	//	删除最大值，不断遍历，直到最右结点
	public void deleteMax()
	{
		root = deleteMax(root);
	}
	private Node deleteMax(Node x)
	{
		//	右子树为空，只剩下左子树
		if(x.right == null)
			return x.left;
		x.right = deleteMax(x.right);	//不断遍历
		x.N = size(x.right) + size(x.left) + 1;	//	需要改变N值
		return x;
	}
	
	//	最难实现的方法 —— delete 操作	需要改变树的结构
	public void delete(Key key)
	{
		root = delete(root, key);
	}
	private Node delete(Node x, Key key)
	{
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			x.left = delete(x.left, key);
		else if(cmp > 0)
			x.right = delete(x.right, key);
		else	// 相等时
		{
			if(x.right == null)
				return x.left;
			if(x.left == null)
				return x.right;
			Node temp = x;
			x = min(temp.right);
			x.right = deleteMin(temp.right);
			x.left = temp.left;
		}
		return x;
	}
	
	//	中序遍历输出二叉树
	public void print()
	{
		print(root);
	}
	private void print(Node x)
	{
		if(x == null)
			return;
		print(x.left);
		System.out.println("key :  " + x.key + "   value: " + x.val);
		print(x.right);
	}
	
	//	二叉查找树的范围操作
	private void keys(Node x, myQueue<Key> queue, Key lo, Key hi)
	{
		if( x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo < 0)
			keys(x.left, queue, lo, hi);
		if(cmphi > 0)
			keys(x.right, queue, lo, hi);
		if(cmplo <=0 && cmphi >= 0)
			queue.enQueue(x.key);
	}
	
	public Iterable<Key> keys(Key lo, Key hi)
	{
		myQueue<Key> queue = new myQueue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	public Iterable<Key> keys()
	{
		return keys(min(),max());
	}
	
	
	/*
	 * 此处是非递归实现二叉查找树
	 * 实际应用中以非递归的为主
	 * */
	//	插入并排序,非递归			已实现
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
			if(cmp < 0)
			{
				if(x.left == null)
				{
					x.left = new Node(key, val, 1);
					return;
				}
				x = x.left;
			}
			else if(cmp > 0)
			{
				if(x.right == null)
				{
					x.right = new Node(key, val, 1);
					return;
				}
				x = x.right;
			}
			else
			{
				x.val = val;
				return;
			}
		}
		x.N = size(x.left) + size(x.right) + 1;
	}
	
	//	查找并返回值，非递归,已实现
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
	
	public static int aplusb(int a, int b) {
        // write your code here
		if (b == 0)
	        return a;
	    return aplusb(a ^b, (a&b) << 1);
    }
	
	public static void main(String[] args)
	{
		BST bst = new BST();
		bst.NoRecursivePut(5, 11);
		bst.NoRecursivePut(11, 7);
		bst.NoRecursivePut(1, 7);
		bst.NoRecursivePut(78, 52);
		bst.print();
		System.out.println("value:"+bst.get(78));
		
		System.out.println(aplusb(100,200));
	}
}
