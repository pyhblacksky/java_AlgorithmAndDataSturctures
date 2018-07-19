package com.my.search;

import com.my.algs.myQueue;

/*
 * ���������ڶ������������ʵ��
 * 2-3������ͨ�������������Ľ�ϣ����2-3������ʵ��
 * ��������ƽ����һ��ƽ��Ķ�����
 * 
 * Сֵ����(left)  ��ֵ����(right)
 * 
 * ��ͨ������������ŵ㣺����Ч�Ĳ��ҷ���
 * 2-3�����ŵ㣺��Ч��ƽ������㷨
 * 
 * �ȼ۶��壺
 * 1.	�����Ӿ�Ϊ������
 * 2.	û���κ�һ�����ͬʱ��������������
 * 3.	����ʶ������ɫƽ��ģ�����������ӵ�������·���ϵĺ�����������ͬ
 * 
 * */

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	/***********************************************************************************/
	//	������ؼ�ʵ��
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	//	�������ɫ���Ǻ�ɫ��ÿ�������Ӻ���ʱ�������Ӹ߶�+1
	private Node root;
	
	private class Node
	{
		Node left, right;	//	������������
		Key key;			//	��
		Value val;			//	�������ֵ
		boolean color;		//	���丸�ڵ�ָ������������ɫ!!
		int N;				//	��������еĽ������
		
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
	
	//	�ں�����֣���������ֺ�ɫ�����Ӻ����������ĺ����ӣ�������Ҫ��ת
	//	��ת���Ա��ֺ�������������ʣ������Ժ�����ƽ����
	//	����ת �������� ��������ת�����
	//	����ת������ɫ������תΪ��,���ø��ڵ㣨�����㣩�����ֺ�ɫ������ʱʹ�� 
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
	
	//	����ת ���������� ����������ת���ұ�
	//	����ת���������������������ʱ
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
	
	//	��һ��˫������3-��㣩�в����½������������ĺ����ӣ���Ҫ��������ȫ��Ϊ������,Ȼ��Դ��������Ǻ�����
	//	��flipColors������ת����ɫ�������ӽڵ��Ϊ��ɫ��������ɫ�任
	public void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	//	�������,��Ϊ����
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
		//	�������ɫΪ��ɫ
		root.color = BLACK;
	}
	private Node put(Node h, Key key, Value val)
	{
		//	��׼����������͸��ڵ��ú���������
		if(h == null)
			return new Node(key, val, 1, RED);
		
		//	��flipColors������if�����ƶ����������ʵ��2-3-4���Ĳ����������
		
		int cmp = key.compareTo(h.key);
		if(cmp < 0)
			h.left = put(h.left, key, val);
		if(cmp > 0)
			h.right = put(h.right, key, val);
		else	//	��ȣ�������ֵ
			h.val = val;
		
		//	�ؼ�����������˳����������     //�������     / �������
		/*	ԭ�������ɱ�Ϊ�������1��2��3�������������仯��
		 * 			O
		 * 		   //\
		 * 		   O
		 * 	�������1������Ϊ�������2��
		 * 			O
		 * 		   //\
		 * 		   O
		 * 		  /\\		��������ת��
		 * 	�������2��(��Ϊ�������3)
		 * 			O
		 * 		   //\
		 *        O			(������ת)
		 *       //\
		 * 		O
		 * 	   //\
		 * 	�������3����ת����ɫ�仯��
		 * 		    O
		 * 		   //\\
		 * 		   O  O
		 * 		  /\  /\
		 * 
		 * 	��ɫת��������ֹ���������̽�����
		 * 		    ||
		 * 		    O
		 * 		   /\
		 * 		  O  O
		 * 
		 * 	���������´���ʵ��ԭ��
		 * */
		if(isRed(h.right) && !isRed(h.left))
			h = rotateRight(h);
		if(isRed(h.left) && isRed(h.left.left))
			h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.right))
			flipColors(h);
		// +1 �Ǳ�����
		h.N = 1 + size(h.left) + size(h.right);
		return h;
	}
	
	//	����ƽ��ķ���
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
	
	// delete ɾ����������Ϊ����
	/**************************/
	//	ɾ����Сֵ        �������������±任,��֤��ǰ��㲻��2-��㣨��Ϊ������3��㣬��������ʱ4��㣩
	private Node moveRedLeft(Node h)
	{
		//	������h�Ǻ�ɫ��h.left��h.right�Ǻ�ɫ
		//	��h.left����h.left���ӽڵ�֮һ���
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
		//	root ���Ҳ�Ϊ�죬root�ϲ�Ϊһ����
		if(!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if(!isEmpty())
			root.color = BLACK;
	}
	
	/**************************/
	
	//	ɾ�����ֵ
	private Node moveRedRight(Node h)
	{
		//	������hΪ��ɫ��h.left ��  h.right ��Ϊ��ɫ
		//	��h.right ����h.right ���ӽڵ�֮һ���
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
		//	root ���Ҳ�Ϊ�죬root�ϲ�Ϊһ����
		if(!isRed(root.right) && !isRed(root.left))
			root.color = RED;
		root = deleteMax(root);
		if(!isEmpty())
			root.color = BLACK;
	}
	
	/**************************/
	
	//	 ɾ������
	public void delete(Key key)
	{
		//	root ���Ҳ�Ϊ�죬root�ϲ�Ϊһ����
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
	//	���ؽ����
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
	
	//	get��������ѯ
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
	
	//	������С���
	private Node min(Node x)
	{
		if(x.left == null)
			return x;
		return min(x.left);
	}
	//	������С��
	public Key min()
	{
		return min(root).key;
	}
	
	//	 ���������
	private Node max(Node x)
	{
		if(x.right == null)
			return x;
		return max(x.right);
	}
	//	��������
	public Key max()
	{
		return max(root).key;
	}
	
	//	ceiling ����С�ڵ���key������
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
	
	//	floor ����С�ڵ���keyd��С��
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
	
	//	����rank
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
	
	//	�ҳ�����Ϊk�ļ�
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
	
}
