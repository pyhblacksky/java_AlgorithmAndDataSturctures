package com.my.graph;

import com.algs.api.Stack;

/*
 * 	寻找有向环	
 * 
 * 	有向无环图：不含有有向环的有向图
 * 	检测有无有向环，可以检测出拓扑排序是否可以实现
 * 	应用较广
 * 
 * */

public class DirectedCycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;	//	记录有向环中的所有顶点(如果存在)
	private boolean[] onStack;		//	递归调用栈上的所有顶点
	
	public DirectedCycle(Digraph G)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
		{
			dfs(G, v);		//	对图中每一个点进行检测
		}
		
	}
	
	private void dfs(Digraph G, int v)
	{
		onStack[v] = true;
		marked[v] = true;		//	标记这一次循环起点
		for(int w : G.adj(v))
		{
			if(hasCycle())
				return;
			else if(!marked[w])
			{
				edgeTo[w] = v;	//	标记最后一次经过的点
				dfs(G, w);
			}
			else if(onStack[w])	//	检测到当前点的邻接点为已标记过的点，可入栈（关键步骤）
			{
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
				{
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle()
	{
		return cycle != null;
	}
	
	public Iterable<Integer> cycle()
	{
		return cycle;
	}
}
