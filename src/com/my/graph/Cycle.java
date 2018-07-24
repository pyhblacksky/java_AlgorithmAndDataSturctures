package com.my.graph;

/*	
 * 	无环图：一个无回路的图
 * 	功能：判断是G是否为无环图
 * 		假设不存在自环或平行边
 * 	
 * 	检测环
 * 
 * */

public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph G)
	{
		marked = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++)
		{
			if(!marked[s])
				dfs(G, s, s);	//	起点和终点均为自己，返回真，则说明存在环
		}
	}
	
	public void dfs(Graph G, int v, int u)
	{
		marked[v] = true;
		for(int w : G.adj(v))	//	对于v的每一个相邻点来说
		{
			if(!marked[w])
				dfs(G, w, v);
			else if(w != u)		//	 其余点均已标记，v和u不是邻接点，说明存在一条路
				hasCycle = true;
		}
	}
	
	public boolean hasCycle()
	{
		return hasCycle;
	}
	
}
