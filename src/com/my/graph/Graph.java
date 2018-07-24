package com.my.graph;

import com.algs.api.Bag;
import com.algs.api.In;

/*
 * 	ͼ��ʵ��
 * 	����Ӧ�õ����ݽṹ��
 * 	1.	�ڽӾ���
 * 	2.	�ߵ�����
 * 	3.	�ڽӱ�����
 * 	
 * 	��ʵ��ʹ�ã��ڽӱ�����	
 * 
 * */

public class Graph {
	
	private final int V;	//	����
	private int E;	//	��
	private Bag<Integer>[] adj;
	
	
	//	����һ������V�����㵫�����ߵ�ͼ
	public Graph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];	//	�����ڽӱ�
		for(int v = 0; v < V; v++)		//	�����������ʼ��Ϊ��
		{
			adj[v] = new Bag<Integer>();
		}
	}
	
	//	�ñ�׼������In������һ��ͼ
	public Graph(In in)
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
	
	//	������
	public int V()
	{
		return V;
	}
	
	//	����
	public int E()
	{
		return E;
	}
	
	//	��ͼ�����һ����v-w
	public void addEdge(int v, int w)
	{
		adj[v].add(w);	//	��v��ӵ�w������
		adj[w].add(v);	//	��w��ӵ�v������
		E++;
	}
	
	//	��v���ڵ����ж���,������������˳��ȷ��
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	//	������ַ�����ʾ, ͼ���ڽӱ���ַ�����ʾ��Graph��ʵ��������
	public String toString()
	{
		String s = V + " vertices,  " + E + " edges\n";
		for(int v = 0; v < V; v++)
		{
			s += v + ": ";
			for(int w : this.adj(v))
			{
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	
	//	����v�Ķ���
	public static int degree(Graph G, int v)
	{
		int degree = 0;
		for(int w : G.adj(v))
			degree++;
		return degree;
	}
	
	//	�������ж����������
	public static int maxDegree(Graph G)
	{
		int max = 0;
		for(int v = 0; v < G.V(); v++)
			if(G.degree(G, v) > max)
				max = G.degree(G, v);
		return max;
	}
	
	//	�������ж����ƽ������
	public static double avgDegree(Graph G)
	{
		//	�����ֶ���ɵ�	2���ı����������е����֮��
		return 2.0*G.E() / G.V();
	}
	
	//	�����Ի��ĸ���
	public static int numberOfSelfLoops(Graph G)
	{
		int count = 0;
		for(int v = 0; v < G.V(); v++)
			for(int w : G.adj(v))
				if(v == w)
					count++;
		return count / 2;	//	����ÿ���߱���������
	}
	
	
}
