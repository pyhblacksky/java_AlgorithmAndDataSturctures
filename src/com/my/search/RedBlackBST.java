package com.my.search;

import com.my.algs.myQueue;

/*
 * 红黑树（红黑二叉查找树）的实现
 * 2-3树和普通二叉树查找树的结合，相比2-3树易于实现
 * 将红链画平就是一颗平衡的二叉树
 * 
 * 小值在左(left)  大值在右(right)
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
	
	/***********************************************************************************/
	//	红黑树关键实现
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	//	根结点颜色总是黑色，每当根结点从红变黑时，黑链接高度+1
	private Node root;
	
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
	//	左旋转 ———— 将红链接转到左边
	//	左旋转，将红色右链接转为左,重置父节点（或根结点），出现红色右链接时使用 
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
	
	//	右旋转 ————— 将红链接旋转到右边
	//	右旋转，出现连续两条左红链接时
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
	//	用flipColors方法来转换颜色，左右子节点均为红色，进行颜色变换
	public void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	//	插入操作,较为复杂
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
		//	根结点颜色为黑色
		root.color = BLACK;
	}
	private Node put(Node h, Key key, Value val)
	{
		//	标准插入操作，和父节点用红链接连接
		if(h == null)
			return new Node(key, val, 1, RED);
		
		//	将flipColors操作和if条件移动到这里，可以实现2-3-4树的插入操作！！
		
		int cmp = key.compareTo(h.key);
		if(cmp < 0)
			h.left = put(h.left, key, val);
		if(cmp > 0)
			h.right = put(h.right, key, val);
		else	//	相等，仅更新值
			h.val = val;
		
		//	关键操作，插入顺序，由下向上     //代表红链     / 代表黑链
		/*	原树：（可变为插入操作1、2、3，根据条件来变化）
		 * 			O
		 * 		   //\
		 * 		   O
		 * 	插入操作1：（变为插入操作2）
		 * 			O
		 * 		   //\
		 * 		   O
		 * 		  /\\		（需左旋转）
		 * 	插入操作2：(变为插入操作3)
		 * 			O
		 * 		   //\
		 *        O			(需右旋转)
		 *       //\
		 * 		O
		 * 	   //\
		 * 	插入操作3：（转入颜色变化）
		 * 		    O
		 * 		   //\\
		 * 		   O  O
		 * 		  /\  /\
		 * 
		 * 	颜色转换：（终止操作，过程结束）
		 * 		    ||
		 * 		    O
		 * 		   /\
		 * 		  O  O
		 * 
		 * 	以上是以下代码实现原理
		 * */
		if(isRed(h.right) && !isRed(h.left))
			h = rotateRight(h);
		if(isRed(h.left) && isRed(h.left.left))
			h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.right))
			flipColors(h);
		// +1 是本身结点
		h.N = 1 + size(h.left) + size(h.right);
		return h;
	}
	
	//	保持平衡的方法
	private Node balance(Node h)
	{
		if(isRed(h.right))
			h = rotateLeft(h);
			
		if(isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right))
			flipColors(h);
			
		h.N = 1 + size(h.left) + size(h.right);
		return h;
	}
	
	// delete 删除操作，更为复杂
	/**************************/
	//	删除最小值        沿着左链接向下变换,保证当前结点不是2-结点（变为可能是3结点，可能是临时4结点）
	private Node moveRedLeft(Node h)
	{
		//	假设结点h是红色，h.left和h.right是黑色
		//	将h.left或者h.left的子节点之一变红
		flipColors(h);
		if(isRed(h.right.left))
		{
			h.right = rotateRight(h.right);
			h = rotateLeft(h);	
		}
		return h;
	}
	private Node deleteMin(Node h)
	{
		if(h.left == null)
			return null;
		if(!isRed(h.left) && !isRed(h.left.left))
			h = moveRedLeft(h);
		h.left = deleteMin(h.left);
		return balance(h);
	}
	public void deleteMin()
	{
		//	root 左右不为红，root合并为一个红
		if(!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if(!isEmpty())
			root.color = BLACK;
	}
	
	/**************************/
	
	//	删除最大值
	private Node moveRedRight(Node h)
	{
		//	假设结点h为红色，h.left 和  h.right 均为黑色
		//	将h.right 或者h.right 的子节点之一变红
		flipColors(h);
		if(!isRed(h.left.left))
			h = rotateRight(h);
		return h;
	}
	private Node deleteMax(Node h)
	{
		if(isRed(h.left))
			h = rotateRight(h);
		if(h.right == null)
			return null;
		if(!isRed(h.right) && !isRed(h.right.left))
			h = moveRedRight(h);
		h.right = deleteMax(h.right);
		return balance(h);
	}
	public void deleteMax()
	{
		//	root 左右不为红，root合并为一个红
		if(!isRed(root.right) && !isRed(root.left))
			root.color = RED;
		root = deleteMax(root);
		if(!isEmpty())
			root.color = BLACK;
	}
	
	/**************************/
	
	//	 删除操作
	public void delete(Key key)
	{
		//	root 左右不为红，root合并为一个红
		if(!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = delete(root, key);
		if(!isEmpty())
			root.color = BLACK;
	}
	private Node delete(Node h, Key key)
	{
		if(key.compareTo(h.key) < 0)
		{
			if(!isRed(h.left) && !isRed(h.left.left))
				h = moveRedRight(h);
			h.left = delete(h.left, key);
		}
		else
		{
			if(isRed(h.left))
				h = rotateRight(h);
			if(key.compareTo(h.key) == 0 && (h.right == null))
				return null;
			if(!isRed(h.right) && !isRed(h.right.left))
				h = moveRedRight(h);
			if(key.compareTo(h.key) == 0)
			{
				h.val = get(h.right, min(h.right).key);
				h.key = min(h.right).key;
				h.right = deleteMin(h.right);
			}
			else 
				h.right = delete(h.right, key);
		}
		return balance(h);
	}
	
	/***********************************************************************************/
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
	
	//	get方法，查询
	private Value get(Node x, Key key)
	{
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
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	//	返回最小结点
	private Node min(Node x)
	{
		if(x.left == null)
			return x;
		return min(x.left);
	}
	//	返回最小键
	public Key min()
	{
		return min(root).key;
	}
	
	//	 返回最大结点
	private Node max(Node x)
	{
		if(x.right == null)
			return x;
		return max(x.right);
	}
	//	返回最大键
	public Key max()
	{
		return max(root).key;
	}
	
	//	ceiling 返回小于等于key的最大键
	private Node ceiling(Node h, Key key)
	{
		if(h == null)
			return null;
		int cmp = key.compareTo(h.key);
		if(cmp == 0)
			return h;
		if(cmp > 0)
			return ceiling(h.right, key);
		Node temp = h.left;
		if(temp != null)
			return temp;
		else
			return h;
	}
	public Key ceiling(Key key)
	{
		Node h = ceiling(root, key);
		if(h == null)
			return null;
		return h.key;
	}
	
	//	floor 返回小于等于keyd最小键
	private Node floor(Node h, Key key)
	{
		if(h == null)
			return null;
		int cmp = key.compareTo(h.key);
		if(cmp == 0)
			return h;
		if(cmp < 0)
			return floor(h.left, key);
		Node temp = h.right;
		if(temp != null)
			return temp;
		else
			return h;
	}
	public Key floor(Key key)
	{
		Node h = floor(root, key);
		if(h == null)
			return null;
		return h.key;
	}
	
	//	排名rank
	private int rank(Node h, Key key)
	{
		if(h == null)
			return 0;
		int cmp = key.compareTo(h.key);
		if(cmp < 0)
			return rank(h.left, key);
		else if(cmp > 0)
			return 1 + size(h.left) + size(h.right);
		else
			return size(h.left);
	}
	public int rank(Key key)
	{
		return rank(root, key);
	}
	
	//	找出排名为k的键
	private Node select(Node h, int k)
	{
		if(h == null)
			return null;
		int t = size(h.left);
		if(t > k)
			return select(h.left, k);
		else if(t < k)
			return select(h.right, k-t-1);
		else
			return h;
	}
	public Key select(int k)
	{
		return select(root, k).key;
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
	
}
