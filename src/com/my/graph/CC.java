package com.my.graph;

/*
 * 	用深度优先搜索找出图中所有的连通分量
 * 	图的连通性	
 * 
 * */

public class CC {
	
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G, int s)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int x = 0; x < G.V(); x++)
		{	
			//	检索G中所有顶点，找出其连通分量
			if(!marked[x])
			{
				dfs(G, x);
				count++;
			}
		}
	}
	
	//	DFS，深搜
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	
	//	返回连通数
	public int count()
	{
		return count;
	}
	
	//	是否连通
	public boolean connected(int v, int w)
	{
		return id[v] == id[w];
	}
	
	//	id 返回
	public int id(int v)
	{
		return id[v];
	}
}
