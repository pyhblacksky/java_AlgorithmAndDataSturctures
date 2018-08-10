package com.my.graph;

import com.algs.api.IndexMinPQ;
import com.algs.api.Stack;

/*
 * 	���·���ĵϽ�˹�����㷨
 * 	Ѱ�Ҵ�s��v�����·	
 * 
 * */

public class DijkstraSP {
	
	private DirectedEdge[] edgeTo;	//	���·�����еı�
	private double[] distTo;		//	�������ľ���
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s)
	{
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;	//	Ĭ��Ϊ�����
		
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty())
			relax(G, pq.delMin());
	}
	
	//	������ɳ�
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
	
	//	��׼��ѯ,	Ĭ��SP������
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