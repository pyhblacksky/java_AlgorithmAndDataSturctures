package com.my.graph;

import com.algs.api.Queue;
import com.algs.api.Stack;

/*
 *	�����������㷨��������и�Ȩֵ�����·���㷨
 * 	
 * 	�˴�ʵ�ֵ��ǻ��ڶ��е�BellmanFord �㷨
 * */

public class BellmanFordSP {
	
	private double[] distTo;				//	����㵽ĳ�������·������
	private DirectedEdge[] edgeTo;			//	����㵽ĳ����������һ��
	private boolean[] onQ;					//	�ö����Ƿ�λ�ڶ�����
	private Queue<Integer> queue;			//	���ڱ����ɵĶ��㣬(�ɳڵĶ���)
	private int cost;						//	relax()���õĴ���
	private Iterable<DirectedEdge> cycle;	//	edgeTo[]���Ƿ��и�Ȩ�صĻ�
	
	//	s�����
	public BellmanFordSP(EdgeWeightedDigraph G, int s)
	{
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		onQ = new boolean[G.V()];
		queue = new Queue<Integer>();
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;
		
		while(!queue.isEmpty() && !hasNegativeCycle())
		{
			int v = queue.dequeue();
			onQ[v] = false;
			relax(G, v);
		}
	}
	
	//	Bellman-Ford�㷨���ɳڲ���
	private void relax(EdgeWeightedDigraph G, int v)
	{
		for(DirectedEdge e : G.adj(v))
		{
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight())
			{
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(!onQ[w])
				{
					queue.enqueue(w);
					onQ[w] = true;
				}
			}
			if(cost++ % G.V() == 0)
				findNegativeCycle();
		}
	}
	
	//	��Ȩ�ػ���ⷽ��
	private void findNegativeCycle()
	{
		int V = edgeTo.length;
		EdgeWeightedDigraph spt;
		spt = new EdgeWeightedDigraph(V);
		for(int v = 0; v < V; v++)
		{
			if(edgeTo[v] != null)
				spt.addEdge(edgeTo[v]);
		}
		
		EdgeWeightedDirectedCycle cf;
		cf = new EdgeWeightedDirectedCycle(spt);
		
		cycle = cf.cycle();
	}
	
	public boolean hasNegativeCycle()
	{
		return cycle != null;
	}
	
	public Iterable<DirectedEdge> negativeCycle()
	{
		return cycle;
	}
	
	//	��׼��ѯ����
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
