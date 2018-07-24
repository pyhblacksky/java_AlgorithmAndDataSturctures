package com.my.graph;

/*
 * 	����ǿ��ͨ������kosaraju�㷨
 * 
 * */

public class KosarajuSCC {
	
	private boolean[] marked;
	private int count = 0;
	private int[] id;
	
	public KosarajuSCC(Digraph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost())
		{
			if(!marked[s])
			{
				dfs(G, s);
				count++;
			}
		}
	}
	
	//	DFS
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
		{
			if(!marked[w])
				dfs(G, w);
		}
	}
	
	//	�Ƿ�ǿ��ͨ
	public boolean stronglyConnected(int v, int w)
	{
		return id[v] == id[w];
	}
	
	public int id(int v)
	{
		return id[v];
	}
	
	public int count()
	{
		return count;
	}
}
