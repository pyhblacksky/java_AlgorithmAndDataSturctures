package com.my.graph;

import com.algs.api.IndexMinPQ;
import com.algs.api.Stack;

/*
 * 	最短路径的迪杰斯特拉算法
 * 
 * */

public class DijkstraSP {
	
	private DirectedEdge[] edgeTo;	//	最短路径树中的边
	private double[] distTo;		//	到达起点的距离
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s)
	{
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;	//	默认为无穷大
		
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty())
			relax(G, pq.delMin());
	}
	
	//	顶点的松弛
	private void relax(EdgeWeightedDigraph G, int v)
	{
		for(DirectedEdge e : G.adj(v))
		{
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight())
			{
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w))
					pq.change(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}
	
	//	标准查询,	默认SP均包含
	public double distTo(int v)
	{
		return distTo[v];
	}
	
	public boolean hasPathTo(int v)
	{
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<DirectedEdge> pathTo(int v)
	{
		if(!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
}
