package com.my.graph;

import com.algs.api.StdOut;

/*
 * 	实现拓扑排序
 * 	
 * 	一幅有向无环图的拓扑顺序即为所有顶点的逆后序排列
 * 
 * */

public class Topological {
	
	private Iterable<Integer> order;	//	顶点的拓扑排序
	
	public Topological(Digraph G)
	{
		DirectedCycle cycleFinder = new DirectedCycle(G);
		if(!cycleFinder.hasCycle())		//	不含有有向环，则执行
		{
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	
	//	是否为有向无环图
	public boolean isDAG()
	{
		return order != null;
	}
	
	public Iterable<Integer> order()
	{
		return order;
	}
	
	//	测试所用程序
	public static void main(String[] args)
	{
		String filename = args[0];
		String separator = args[1];
		SymbolDigraph sg = new SymbolDigraph(filename, separator);
		
		Topological top = new Topological(sg.G());
		
		for(int v : top.order())
			StdOut.println(sg.name(v));		
	}
	
}
