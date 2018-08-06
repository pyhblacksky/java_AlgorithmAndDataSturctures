package com.my.graph;

import com.algs.api.MinPQ;
import com.algs.api.Queue;
import com.my.algs.UF;

/*
 * 	��С��������kruskal�㷨��������СȨֵ�������ɻ��������
 * 	�ҵ�V-1���ߺ�ֹͣ
 * 
 * 
 * */

public class KruskalMST {

	private Queue<Edge> mst;
	
	public KruskalMST(EdgeWeightedGraph G)
	{
		mst = new Queue<Edge>();
		
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for(Edge e : G.edges())
			pq.insert(e);
		
		//	��̬����
		UF uf = new UF(G.V());
		
		while(!pq.isEmpty() && mst.size() < G.V()-1)
		{
			Edge e = pq.delMin();	//	��pq�õ�Ȩ����С�ıߺ����Ķ���
			int v = e.either();
			int w = e.other(v);
			
			if(uf.connected(v, w))	//	����ʧЧ�ı�
				continue;
			uf.union(v, w);			//	�ϲ�����
			mst.enqueue(e); 		//	������ӵ���С��������
		}
	}
	
	public Iterable<Edge> edges()
	{
		return mst;
	}
	
	//public double weight()

}
