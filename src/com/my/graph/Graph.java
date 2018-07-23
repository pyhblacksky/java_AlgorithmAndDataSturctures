package com.my.graph;

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
	
	public int V;	//	����
	public int E;	//	��
	
	//	����һ������V�����㵫�����ߵ�ͼ
	public Graph(int v)
	{
		
	}
	
	//	�ñ�׼������In������һ��ͼ
	/*
	public Graph(In in)
	{
		
	}
	*/
	
	//	������
	public int V()
	{
		return 0;
	}
	
	//	����
	public int E()
	{
		return 0;
	}
	
	//	��ͼ�����һ����v-w
	public void addEdge(int v, int w)
	{
		
	}
	
	//	��v���ڵ����ж���,������������˳��ȷ��
	public Iterable<Integer> adj(int v)
	{
		return null;
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
