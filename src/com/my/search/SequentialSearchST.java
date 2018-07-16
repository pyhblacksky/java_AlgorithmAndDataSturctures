package com.my.search;
import com.algs.api.*;

/*
 * ˳����ң�������������
 * 
 * */

public class SequentialSearchST<Key, Value> {

	//	ʹ������ ��������
	private class Node
	{
		//	������Ķ���
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	private Node first;	//	�����׽�� 	
	
	private int N = 0;	//	���ڼ���
	
	//	����ֵ�Դ�����У���ֵΪ���򽫼�key�ӱ���ɾ����
	public void put(Key key, Value val)
	{
		//	���Ҹ����ļ����ҵ��������ֵ�������ڱ����½����
		for(Node x = first; x != null; x=x.next)
		{
			//	�����У������
			if(key.equals(x.key))
			{
				x.val = val;
				return;
			}
		}
		//	û�У��½����
		first = new Node(key, val, first);
	}
	
	//	��ȡ��key��Ӧ��ֵ����key�������򷵻ؿգ�
	public Value get(Key key)
	{
		//	���Ҹ����ļ������ع�����ֵ
		for(Node x = first; x != null; x = x.next)
		{
			if(key.equals(x.key))
			{
				return x.val;	//	���У��ɹ��ҵ�
			}
		}
		return null;	//	δ���У�����null
	}
	
	//	�ӱ���ɾȥkey
	public void delete(Key key)
	{
		put(key, null);
	}
	
	//	��key�Ƿ�����ڱ���
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	//	���Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	//	���еļ�ֵ������
	public int size()
	{
		int N = 0;
		for(Node x = first; x != null; x = x.next)
		{
			N++;
		}
		return N;
	}
	
	//	��С�ļ�
	public Key min()
	{
		return null;
	}
	
	//	���ļ�
	public Key max()
	{
		return null;
	}
	
	//	С�ڵ���key������
	public Key floor(Key key)
	{
		return null;
	}
	
	//	���ڵ���key����С��
	public Key ceiling(Key key)
	{
		return null;
	}
	
	//	С��key�ļ�����
	public int rank(Key key)
	{
		return 0;
	}
	
	//	����Ϊk�ļ�
	public Key select(int k)
	{
		return null;
	}
	
	//	ɾ����С�ļ�
	public void deleteMin()
	{
		delete(min());
	}
	
	//	ɾ�����ļ�
	public void deleteMax()
	{
		delete(max());
	}
	
	//	[lo..hi]֮���������
	public int size(Key lo, Key hi)
	{
		int N = 0;
		for(Node x = first; x != null; x = x.next)
		{
			if(lo.equals(x.key))
			{
				while(!hi.equals(x.key))
				{
					x = x.next;
					N++;
				}
			}
		}
		return N;
	}
	
	//	[lo..hi]֮������м���������
	public Iterable<Key> keys(Key lo, Key hi)
	{
		return null;
	}
	
	//	�������м��ļ��ϣ�������
	public Iterable<Key> keys()
	{
		return keys(min(), max());
	}
	
	//	��ʾ������
	public void show()
	{
		for(Node x = first; x != null; x = x.next)
		{
			StdOut.print("key:"+x.key+"  value:"+x.val);
			StdOut.println();
		}
		StdOut.println();
	}
}
