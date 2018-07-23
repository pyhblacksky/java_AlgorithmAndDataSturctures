package com.my.graph;

/*
 * 	���ܣ��ж��Ƿ�Ϊżͼ������ͼ������˫ɫ����
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
		for(int s = 0; s < G.V(); s++)	//	����G��ÿһ����
		{
			if(!marked[s])
				dfs(G, s);	
		}
	}
	
	
	//	DFS
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))	//	����ͼG��ÿһ���ڽӵ���˵
		{
			if(!marked[w])
			{
				color[w] = !color[v];
				dfs(G, v);
			}
			else if(color[w] == color[v])	//	�����ѱ�ǵĵ�,���м��
				isTwoColorable = false;
		}
	}
	
	public boolean isBipartite()
	{
		return isTwoColorable;
	}
}
