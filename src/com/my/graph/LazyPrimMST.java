package com.my.graph;

import com.algs.api.MinPQ;
import com.algs.api.Queue;

/*
 * 	Prim算法分  即时型  和  延迟型
 * 	这里使用延迟型Prim算法——LazyPrim
 * 	Prim算法实现最小生成树
 * 
 * */

public class LazyPrimMST {
	
	private boolean[] marked;	//	最小生成树的顶点
	private Queue<Edge> mst;	//	最小生成树的边
	private MinPQ<Edge> pq;		//	横切边（包括失效边）
	
	public LazyPrimMST(EdgeWeightedGraph G)
	{
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		
		//	假设G是连通的
		visit(G, 0);
		while(!pq.isEmpty())
		{
			Edge e = pq.delMin();	//	从pq中得到权重最小的边
			
			//	对于边e的两端点来说
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w])
				continue;	//	跳过失效的边
			mst.enqueue(e);	//	将边添加到树中
			//	将顶点v或w添加到树中
			if(!marked[v])
				visit(G, v);
			if(!marked[w])
				visit(G, w);
		}
		
	}
	
	//	标记顶点v并将所有连接v和未被标记顶点的边加入pq
	private void visit(EdgeWeightedGraph G, int v)
	{
		marked[v] = true;
		for(Edge e : G.adj(v))
		{
			//	对其未标记顶点
			if(!marked[e.other(v)])
				pq.insert(e);
		}
	}
	
	//	迭代器
	public Iterable<Edge> edges()
	{
		return mst;
	}
	
	//	返回权重
	//public double weight()
}
