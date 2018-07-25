package com.my.graph;

/*
 * 	��Ȩ�صıߵ���������
 * 
 * */

public class Edge implements Comparable<Edge>{
	
	private final int v;			//	����֮һ
	private final int w;			//	��һ������
	private final double weight;	//	�����Ȩ��
	
	public Edge(int v, int w, int weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	//	�ߵ�Ȩ��
	public double weight()
	{
		return weight;
	}
	
	//	�����˵Ķ���֮һ
	public int either()
	{
		return v;
	}
	
	//	��һ������
	public int other(int vertex)
	{
		if(vertex == v)
			return w;
		else if(vertex == w)
			return v;
		else
			throw new RuntimeException("Inconsistent edge.");
	}
	
	//	����������that�߱Ƚ�
	public int compareTo(Edge that)
	{
		if(this.weight() < that.weight())
			return -1;
		else if(this.weight() > that.weight())
			return +1;
		else
			return 0;
	}
	
	//	������ַ�����ʾ
	public String toString()
	{
		return String.format("%d - %d, %.2f", v, w, weight);
	}
}
