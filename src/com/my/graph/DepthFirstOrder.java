package com.my.graph;

import com.algs.api.Queue;
import com.algs.api.Stack;

/*
 * 	有向图中基于深度优先搜索的顶点排序
 * 	
 * 	需要三个数据结构：
 * 	pre——所有顶点的前序排列，队列
 * 	post——所有顶点的后序排列，队列
 * 	reversePost——所有顶点的逆后序排列，栈	
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
		for(int v = 0; v < G.V(); v++)	//	对于图G的每一个点
		{
			dfs(G, v);
		}
	}
	
	private void dfs(Digraph G, int v)
	{
		pre.enqueue(v);		//	点入队列
		marked[v] = true;	//	标记起点
		for(int w : G.adj(v))
		{
			if(!marked[w])
				dfs(G, w);
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	//	返回前序
	public Iterable<Integer> pre()
	{
		return pre;
	}
	
	//	返回后序
	public Iterable<Integer> post()
	{
		return post;
	}
	
	//	返回逆后序
	public Iterable<Integer> reversePost()
	{
		return reversePost;
	}
	
}
