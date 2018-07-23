package com.my.graph;

import com.algs.api.Stack;

/*
 * 	ʹ��(DFS)�����������ͼ�е�·��
 * 	
 * */

public class DepthFirstPaths {
	
	private boolean[] marked;	//	���������ù�DFS����
	private int[] edgeTo;		//	����㵽һ���������֪·���ϵ����һ������
	private final int s;
	
	//	��G���ҳ��������Ϊs��·��
	public DepthFirstPaths(Graph G, int s)
	{
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}
	
	//	DFS	�����������
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))
		{
			if(!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	//	��㵽��v�Ƿ����·��
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	//	s �� v ��·������������ڣ��򷵻�null
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x])
		{
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
}
