package com.my.graph;

/*
 * 	实现	深度优先搜索（DFS）
 * 
 * 
 * */

public class DepthFirstSearch {
	private boolean[] maked;
	private int count;
	
	//	找到和起点s连通的所有顶点
	public DepthFirstSearch(Graph G, int s)
	{
		maked = new boolean[G.V()];
		dfs(G, s);
	}
	
	//	DFS，深度优先搜索
	private void dfs(Graph G, int v)
	{
		maked[v] = true;
		count++;
		for(int w : G.adj(v))
		{
			if(!maked[w])
				dfs(G, w);
		}
	}
	
	//	v 和  s 是连通的吗
	public boolean maked(int v)
	{
		return maked[v];
	}
	
	//	与s连通的顶点总数
	public int count()
	{
		return count;
	}
	
}
