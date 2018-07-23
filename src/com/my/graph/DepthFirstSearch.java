package com.my.graph;

/*
 * 	ʵ��	�������������DFS��
 * 
 * 
 * */

public class DepthFirstSearch {
	private boolean[] maked;
	private int count;
	
	//	�ҵ������s��ͨ�����ж���
	public DepthFirstSearch(Graph G, int s)
	{
		maked = new boolean[G.V()];
		dfs(G, s);
	}
	
	//	DFS�������������
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
	
	//	v ��  s ����ͨ����
	public boolean maked(int v)
	{
		return maked[v];
	}
	
	//	��s��ͨ�Ķ�������
	public int count()
	{
		return count;
	}
	
}
