package com.my.graph;

import com.algs.api.Stack;

/*
 * 	使用(DFS)深度优先搜索图中的路径
 * 	
 * */

public class DepthFirstPaths {
	
	private boolean[] marked;	//	这个顶点调用过DFS了吗？
	private int[] edgeTo;		//	从起点到一个顶点的已知路径上的最后一个顶点
	private final int s;
	
	//	在G中找出所有起点为s的路径
	public DepthFirstPaths(Graph G, int s)
	{
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}
	
	//	DFS	深度优先搜索
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))
		{
			if(!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	//	起点到点v是否存在路径
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	//	s 到 v 的路径，如果不存在，则返回null
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x])
		{
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
}
