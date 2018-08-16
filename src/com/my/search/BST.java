package com.my.search;

import com.algs.api.StdOut;
import com.my.algs.myQueue;

/*
 * ���������ʵ�ֲ���
 * 
 * �������������С�Ҵ�������С�ڸ���㣬���������ڸ����
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
	//	������С���
	private Node min(Node x)
	{
		if(x.left == null)
			return x;
		return min(x.left);
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
	//	���������
	private Node max(Node x)
	{
		if(x.right == null)
			return x;
		return max(x.right);
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
	
	//	����rank��
	public int rank(Key key)
	{
		return rank(root, key);
	}
	//	������xΪ������������С��x.key�ļ�������
	private int rank(Node x, Key key)
	{
		if(x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return rank(x.left, key);
		else if(cmp > 0)		//	rank(x.right, key) Ϊ�˷������еı�keyС����������Ŀ
			return 1 + size(x.left) + rank(x.right, key);
		else //	��keyС�ļ�����
			return size(x.left);
	}
	
	//	�ҳ�����Ϊk�ļ�
	public Key select(int k)
	{
		return select(root, k).key;
	}
	private Node select(Node x, int k)
	{
		//	��������Ϊk�Ľ��
		if(x == null)
			return null;
		int t = size(x.left);
		if(t > k)	//	ȫ��kС
			return select(x.left, k);
		if(t < k)	//	k�Ƚϴ� ��Ҫ��Сkֵ���б���
			return select(x.right, k-t-1);
		else
			return x;
	}
	
	//	ɾ����Сֵ�����ϱ�����ֱ��������
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	private Node deleteMin(Node x)
	{
		//	��������Ϊ�գ���ʣ��������
		if(x.left == null)
			return x.right;	//	����������������
		x.left = deleteMin(x.left);	// ���ϵݹ����
		x.N = size(x.left) + size(x.right) + 1;	//	��Ҫ�ı�Nֵ
		return x;
	}
	
	//	ɾ�����ֵ�����ϱ�����ֱ�����ҽ��
	public void deleteMax()
	{
		root = deleteMax(root);
	}
	private Node deleteMax(Node x)
	{
		//	������Ϊ�գ�ֻʣ��������
		if(x.right == null)
			return x.left;
		x.right = deleteMax(x.right);	//���ϱ���
		x.N = size(x.right) + size(x.left) + 1;	//	��Ҫ�ı�Nֵ
		return x;
	}
	
	//	����ʵ�ֵķ��� ���� delete ����	��Ҫ�ı����Ľṹ
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
		else	// ���ʱ
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
	
	//	����������������
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
	
	//	����������ķ�Χ����
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
	 * �˴��Ƿǵݹ�ʵ�ֶ��������
	 * ʵ��Ӧ�����Էǵݹ��Ϊ��
	 * */
	//	���벢����,�ǵݹ�			��ʵ��
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
	
	//	���Ҳ�����ֵ���ǵݹ�,��ʵ��
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
	
	
	public static void main(String[] args)
	{
		BST bst = new BST();
		bst.NoRecursivePut(5, 11);
		bst.NoRecursivePut(11, 7);
		bst.NoRecursivePut(1, 7);
		bst.NoRecursivePut(78, 52);
		bst.print();
		System.out.println("value:"+bst.get(78));
	}
}
