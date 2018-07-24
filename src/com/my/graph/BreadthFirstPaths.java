package com.my.graph;

import com.algs.api.Queue;
import com.algs.api.Stack;

/*
 * 	使用(BFS)广度优先搜索查找图中的路径
 * 	单点最短路径
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
	
	//	BFS,	广度优先搜索
	private void bfs(Graph G, int s)
	{
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;	//	标记起点
		queue.enqueue(s);	//	将它加入队列
		while(!queue.isEmpty())
		{
			int v = queue.dequeue();	//	从队列中删去下一个顶点
			for(int w : G.adj(v))
			{
				if(!marked[w])			//	对于每个未被标记的相邻顶点
				{
					edgeTo[w] = v;		//	保存最短路径的最后一条边
					marked[w] = true;	//	标记它，因为最短路径已知
					queue.enqueue(w);	//	并将它加入队列中
				}
			}
		}
	}
	
	//	是否含有路径到v
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	//	迭代器,	从起点到v的路径
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
