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
	//	����ת������ɫ������תΪ��,���ø��ڵ㣨�����㣩
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
	
	//	����ת
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
	//	��flipColors������ת����ɫ
	public void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	/***************************************/
	
	private Node root;
	
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
	
}
