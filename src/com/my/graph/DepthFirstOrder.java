package com.my.graph;

import com.algs.api.Queue;
import com.algs.api.Stack;

/*
 * 	����ͼ�л���������������Ķ�������
 * 	
 * 	��Ҫ�������ݽṹ��
 * 	pre�������ж����ǰ�����У�����
 * 	post�������ж���ĺ������У�����
 * 	reversePost�������ж������������У�ջ	
 * 
 * */

public class DepthFirstOrder {

	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder(Digraph G)
	{
		marked = new boolean[G.V()];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		for(int v = 0; v < G.V(); v++)	//	����ͼG��ÿһ����
		{
			dfs(G, v);
		}
	}
	
	private void dfs(Digraph G, int v)
	{
		pre.enqueue(v);		//	�������
		marked[v] = true;	//	������
		for(int w : G.adj(v))
		{
			if(!marked[w])
				dfs(G, w);
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	//	����ǰ��
	public Iterable<Integer> pre()
	{
		return pre;
	}
	
	//	���غ���
	public Iterable<Integer> post()
	{
		return post;
	}
	
	//	���������
	public Iterable<Integer> reversePost()
	{
		return reversePost;
	}
	
}
