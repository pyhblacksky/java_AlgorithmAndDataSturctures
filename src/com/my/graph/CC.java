package com.my.graph;

/*
 * 	��������������ҳ�ͼ�����е���ͨ����
 * 	ͼ����ͨ��	
 * 
 * */

public class CC {
	
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G, int s)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int x = 0; x < G.V(); x++)
		{	
			//	����G�����ж��㣬�ҳ�����ͨ����
			if(!marked[x])
			{
				dfs(G, x);
				count++;
			}
		}
	}
	
	//	DFS������
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
	
	//	������ͨ��
	public int count()
	{
		return count;
	}
	
	//	�Ƿ���ͨ
	public boolean connected(int v, int w)
	{
		return id[v] == id[w];
	}
	
	//	id ����
	public int id(int v)
	{
		return id[v];
	}
}
