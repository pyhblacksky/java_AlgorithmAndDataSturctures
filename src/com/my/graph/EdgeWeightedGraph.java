package com.my.graph;

import com.algs.api.Bag;

/*
 * 	加权无向图的数据类型
 * 
 * */

public class EdgeWeightedGraph {
	
	private final int V;	//	顶点总数
	private int E;			//	边数
	private Bag<Edge>[] adj;
	
	//	构造函数
	public EdgeWeightedGraph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for(int v = 0; v < V; v++)
		{
			adj[v] = new Bag<Edge>();
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
	
	//	添加边
	public void addEdge(Edge e)
	{
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public Iterable<Edge> adj(int v)
	{
		return adj[v];
	}
	
	//	 返回加权无向图中的所有边
	public Iterable<Edge> edges()
	{
		Bag<Edge> b = new Bag<Edge>();
		for(int v = 0; v < V; v++)
		{
			for(Edge e : adj[v])
			{
				if(e.other(v) > v)
					b.add(e);
			}
		}
		return b;
	}
}
