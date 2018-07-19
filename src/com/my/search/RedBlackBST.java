package com.my.search;

/*
 * ���������ڶ������������ʵ��
 * 2-3������ͨ�������������Ľ�ϣ����2-3������ʵ��
 * ��������ƽ����һ��ƽ��Ķ�����
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
	
	/***************************************/
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
	//	ɾ����Сֵ        ��֤��ǰ��㲻��2-���
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
		if(!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if(!isEmpty())
			root.color = BLACK;
	}
	
	/**************************/
	
	//	ɾ�����ֵ
	
	
	
	/**************************/
	
	//	 ɾ������
	public void delete(Key key)
	{
		
	}
	
	
	/***************************************/
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
	
}
