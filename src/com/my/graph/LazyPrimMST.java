package com.my.graph;

import com.algs.api.MinPQ;
import com.algs.api.Queue;

/*
 * 	Prim�㷨��  ��ʱ��  ��  �ӳ���
 * 	����ʹ���ӳ���Prim�㷨����LazyPrim
 * 	Prim�㷨ʵ����С������
 * 
 * */

public class LazyPrimMST {
	
	private boolean[] marked;	//	��С�������Ķ���
	private Queue<Edge> mst;	//	��С�������ı�
	private MinPQ<Edge> pq;		//	���бߣ�����ʧЧ�ߣ�
	
	public LazyPrimMST(EdgeWeightedGraph G)
	{
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		
		//	����G����ͨ��
		visit(G, 0);
		while(!pq.isEmpty())
		{
			Edge e = pq.delMin();	//	��pq�еõ�Ȩ����С�ı�
			
			//	���ڱ�e�����˵���˵
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w])
				continue;	//	����ʧЧ�ı�
			mst.enqueue(e);	//	������ӵ�����
			//	������v��w��ӵ�����
			if(!marked[v])
				visit(G, v);
			if(!marked[w])
				visit(G, w);
		}
		
	}
	
	//	��Ƕ���v������������v��δ����Ƕ���ı߼���pq
	private void visit(EdgeWeightedGraph G, int v)
	{
		marked[v] = true;
		for(Edge e : G.adj(v))
		{
			//	����δ��Ƕ���
			if(!marked[e.other(v)])
				pq.insert(e);
		}
	}
	
	//	������
	public Iterable<Edge> edges()
	{
		return mst;
	}
	
	//	����Ȩ��
	//public double weight()
}
