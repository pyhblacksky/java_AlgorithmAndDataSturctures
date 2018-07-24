package com.my.graph;

import com.algs.api.Bag;
import com.algs.api.In;

/*
 * 	����ͼ�����ݽṹ
 * 
 * */

public class Digraph {
	
	private final int V;	//	����
	private int E;			//	��
	private Bag<Integer>[] adj;
	
	//	���캯��
	public Digraph(int V)
	{
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0; i < V; i++)
		{
			adj[i] = new Bag<Integer>();
		}
	}
	
	//	�ñ�׼������In������һ��ͼ
	public Digraph(In in)
	{
		this(in.readInt());	//	��ȡV����ͼ��ʼ��
		int E = in.readInt();	//	��ȡE
		for(int e = 0; e < E; e++)
		{
			//	���һ����
			int v = in.readInt();	//	��v
			int w = in.readInt();	//	��w
			addEdge(v, w);
		}
	}
	
	public int V()
	{
		return V;
	}
	
	public int E()
	{
		return E;
	}
	
	//	������
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	//	��������v,w
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		E++;
	}
	
	//	����������ͼȡ������
	public Digraph reverse()
	{
		Digraph R = new Digraph(V);
		for(int v = 0; v < V; v++)
		{
			for(int w : adj[v])
			{
				R.addEdge(w, v);	//	�߷���
			}
		}
		return R;
	}
	
}
