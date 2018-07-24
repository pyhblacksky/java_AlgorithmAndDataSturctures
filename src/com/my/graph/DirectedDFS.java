package com.my.graph;

import com.algs.api.Bag;
import com.algs.api.In;
import com.algs.api.StdOut;

/*
 * 	有向图的(DFS)深度优先搜索
 * 	有向图的可达性	
 * 
 * */

public class DirectedDFS {
	
	private boolean[] marked;
	
	//	从G中找到从s可达的所有顶点s
	public DirectedDFS(Digraph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	//	在G中找到从sources中的所有顶点可达的所有顶点
	public DirectedDFS(Digraph G, Iterable<Integer> sources)
	{
		marked = new boolean[G.V()];
		for(int w : sources)
			if(!marked[w])
				dfs(G, w);
	}
	
	//	DFS
	public void dfs(Digraph G, int v)
	{
		marked[v] = true;		//	标记起点
		for(int w : G.adj(v))
		{
			if(!marked[w])
				dfs(G, w);
		}
	}
	
	//	v点是否被标记
	public boolean marked(int v)
	{
		return marked[v];
	}
	
	//	测试用的主函数
	public static void main(String[] args)
	{
		In in = new In(args[0]);
		Digraph G = new Digraph(in);
		
		Bag<Integer> sources = new Bag<Integer>();
		for(int i = 1; i < args.length; i++)
			sources.add(Integer.parseInt(args[i]));
		
		DirectedDFS reachable = new DirectedDFS(G, sources);
		
		for(int v = 0; v < G.V(); v++)
			if(reachable.marked(v))
				StdOut.print(v + " ");
		StdOut.println();
		
	}
	
}
