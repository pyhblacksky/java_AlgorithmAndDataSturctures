package com.my.strings;

/*
 * 	基于单词查找树的符号表
 * 
 * 
 * */

public class TrieST<Value> {

	private static int R = 256;	//	基数
	private Node root;			//	单词查找树的根结点
	 
	private static class Node
	{
		private Object val;
		private Node[] next = new Node[R];
	}
	
	//	  外部调用的方法
	public Value get(String key)
	{
		Node x = get(root, key, 0);
		if(x == null)
			return null;
		return (Value)x.val;
	}
	
	//	返回以x作为根结点的子单词查找树中与key相关联的值
	private Node get(Node x, String key, int d)
	{
		if(x == null)
			return null;
		if(d == key.length())
			return x;
		char c = key.charAt(d);		//	找到第d个字符所对应的子单词查找树
		return get(x.next[c], key, d+1);
	}
	
	//	外部调用的方法
	public void put(String key, Value val)
	{
		root = put(root, key, val, 0);
	}
	
	//	如果key存在于以x为根结点的子单词查找树中则更新与它相关联的值
	private Node put(Node x, String key, Value val, int d)
	{
		if(x == null)
			return null;
		if(d == key.length())
		{
			x.val = val;
			return x;
		}
		char c = key.charAt(d);		//	找到第d个字符所对应的子单词查找树
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
		
	}
}
