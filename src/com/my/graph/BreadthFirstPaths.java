package com.my.graph;

import com.algs.api.Queue;
import com.algs.api.Stack;

/*
 * 	ʹ��(BFS)���������������ͼ�е�·��
 * 	�������·��
 * 
 * */

public class BreadthFirstPaths {
	
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths(Graph G, int s)
	{
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
	}
	
	//	BFS,	�����������
	private void bfs(Graph G, int s)
	{
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;	//	������
		queue.enqueue(s);	//	�����������
		while(!queue.isEmpty())
		{
			int v = queue.dequeue();	//	�Ӷ�����ɾȥ��һ������
			for(int w : G.adj(v))
			{
				if(!marked[w])			//	����ÿ��δ����ǵ����ڶ���
				{
					edgeTo[w] = v;		//	�������·�������һ����
					marked[w] = true;	//	���������Ϊ���·����֪
					queue.enqueue(w);	//	���������������
				}
			}
		}
	}
	
	//	�Ƿ���·����v
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	//	������,	����㵽v��·��
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
