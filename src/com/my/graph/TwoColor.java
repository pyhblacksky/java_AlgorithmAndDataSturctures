package com.my.graph;

/*
 * 	功能：判断是否为偶图（二分图）——双色问题
 * 
 * */

public class TwoColor {

	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable = true;
	
	public TwoColor(Graph G)
	{
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++)	//	对于G的每一个点
		{
			if(!marked[s])
				dfs(G, s);	
		}
	}
	
	
	//	DFS
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))	//	对于图G的每一个邻接点来说
		{
			if(!marked[w])
			{
				color[w] = !color[v];
				dfs(G, v);
			}
			else if(color[w] == color[v])	//	对于已标记的点,进行检查
				isTwoColorable = false;
		}
	}
	
	public boolean isBipartite()
	{
		return isTwoColorable;
	}
}
