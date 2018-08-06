package com.my.graph;

import com.algs.api.MinPQ;
import com.algs.api.Queue;
import com.my.algs.UF;

/*
 * 	最小生成树的kruskal算法，计算最小权值，不构成环的情况下
 * 	找到V-1条边后停止
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
		
		//	动态链接
		UF uf = new UF(G.V());
		
		while(!pq.isEmpty() && mst.size() < G.V()-1)
		{
			Edge e = pq.delMin();	//	从pq得到权重最小的边和它的顶点
			int v = e.either();
			int w = e.other(v);
			
			if(uf.connected(v, w))	//	忽略失效的边
				continue;
			uf.union(v, w);			//	合并分量
			mst.enqueue(e); 		//	将边添加到最小生成树中
		}
	}
	
	public Iterable<Edge> edges()
	{
		return mst;
	}
	
	//public double weight()

}
