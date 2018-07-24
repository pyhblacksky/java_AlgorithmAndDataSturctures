package com.my.graph;

/*	
 * 	�޻�ͼ��һ���޻�·��ͼ
 * 	���ܣ��ж���G�Ƿ�Ϊ�޻�ͼ
 * 		���費�����Ի���ƽ�б�
 * 	
 * 	��⻷
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
				dfs(G, s, s);	//	�����յ��Ϊ�Լ��������棬��˵�����ڻ�
		}
	}
	
	public void dfs(Graph G, int v, int u)
	{
		marked[v] = true;
		for(int w : G.adj(v))	//	����v��ÿһ�����ڵ���˵
		{
			if(!marked[w])
				dfs(G, w, v);
			else if(w != u)		//	 �������ѱ�ǣ�v��u�����ڽӵ㣬˵������һ��·
				hasCycle = true;
		}
	}
	
	public boolean hasCycle()
	{
		return hasCycle;
	}
	
}
