package com.my.graph;

import com.algs.api.Bag;
import com.algs.api.In;

/*
 * 	图的实现
 * 	可以应用的数据结构：
 * 	1.	邻接矩阵
 * 	2.	边的数组
 * 	3.	邻接表数组
 * 	
 * 	本实现使用：邻接表数组	
 * 
 * */

public class Graph {
	
	private final int V;	//	顶点
	private int E;	//	边
	private Bag<Integer>[] adj;
	
	
	//	创建一个含有V个顶点但不含边的图
	public Graph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];	//	创建邻接表
		for(int v = 0; v < V; v++)		//	将所有链表初始化为空
		{
			adj[v] = new Bag<Integer>();
		}
	}
	
	//	用标准输入流In来读入一幅图
	public Graph(In in)
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
	
	//	顶点数
	public int V()
	{
		return V;
	}
	
	//	边数
	public int E()
	{
		return E;
	}
	
	//	向图中添加一条边v-w
	public void addEdge(int v, int w)
	{
		adj[v].add(w);	//	将v添加到w链表中
		adj[w].add(v);	//	将w添加到v链表中
		E++;
	}
	
	//	和v相邻的所有顶点,遍历，但遍历顺序不确定
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	//	对象的字符串表示, 图的邻接表的字符串表示（Graph的实例方法）
	public String toString()
	{
		String s = V + " vertices,  " + E + " edges\n";
		for(int v = 0; v < V; v++)
		{
			s += v + ": ";
			for(int w : this.adj(v))
			{
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	
	//	计算v的度数
	public static int degree(Graph G, int v)
	{
		int degree = 0;
		for(int w : G.adj(v))
			degree++;
		return degree;
	}
	
	//	计算所有顶点的最大度数
	public static int maxDegree(Graph G)
	{
		int max = 0;
		for(int v = 0; v < G.V(); v++)
			if(G.degree(G, v) > max)
				max = G.degree(G, v);
		return max;
	}
	
	//	计算所有定点的平均度数
	public static double avgDegree(Graph G)
	{
		//	由握手定理可得	2倍的边数等于所有点度数之和
		return 2.0*G.E() / G.V();
	}
	
	//	计算自环的个数
	public static int numberOfSelfLoops(Graph G)
	{
		int count = 0;
		for(int v = 0; v < G.V(); v++)
			for(int w : G.adj(v))
				if(v == w)
					count++;
		return count / 2;	//	由于每条边被计算两次
	}
	
	
}
