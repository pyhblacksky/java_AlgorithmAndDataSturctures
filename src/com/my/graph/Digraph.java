package com.my.graph;

import com.algs.api.Bag;
import com.algs.api.In;

/*
 * 	有向图的数据结构
 * 
 * */

public class Digraph {
	
	private final int V;	//	顶点
	private int E;			//	边
	private Bag<Integer>[] adj;
	
	//	构造函数
	public Digraph(int V)
	{
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0; i < V; i++)
		{
			adj[i] = new Bag<Integer>();
		}
	}
	
	//	用标准输入流In来读入一幅图
	public Digraph(In in)
	{
		this(in.readInt());	//	读取V并将图初始化
		int E = in.readInt();	//	读取E
		for(int e = 0; e < E; e++)
		{
			//	添加一条边
			int v = in.readInt();	//	点v
			int w = in.readInt();	//	点w
			addEdge(v, w);
		}
	}
	
	public int V()
	{
		return V;
	}
	
	public int E()
	{
		return E;
	}
	
	//	迭代器
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	//	添加有向边v,w
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		E++;
	}
	
	//	新增，有向图取反操作
	public Digraph reverse()
	{
		Digraph R = new Digraph(V);
		for(int v = 0; v < V; v++)
		{
			for(int w : adj[v])
			{
				R.addEdge(w, v);	//	边反向
			}
		}
		return R;
	}
	
}
