package com.my.graph;

/*
 * 	ʵ��	�������������DFS��
 * 
 * 
 * */

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	//	�ҵ������s��ͨ�����ж���
	public DepthFirstSearch(Graph G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	//	DFS�������������
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		count++;
		for(int w : G.adj(v))
		{
			if(!marked[w])
				dfs(G, w);
		}
	}
	
	//	v ��  s ����ͨ����
	public boolean maked(int v)
	{
		return marked[v];
	}
	
	//	��s��ͨ�Ķ�������
	public int count()
	{
		return count;
	}
	
}
