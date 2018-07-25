package com.my.graph;

/*
 * 	带权重的边的数据类型
 * 
 * */

public class Edge implements Comparable<Edge>{
	
	private final int v;			//	顶点之一
	private final int w;			//	另一个顶点
	private final double weight;	//	顶点的权重
	
	public Edge(int v, int w, int weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	//	边的权重
	public double weight()
	{
		return weight;
	}
	
	//	边两端的顶点之一
	public int either()
	{
		return v;
	}
	
	//	另一个顶点
	public int other(int vertex)
	{
		if(vertex == v)
			return w;
		else if(vertex == w)
			return v;
		else
			throw new RuntimeException("Inconsistent edge.");
	}
	
	//	将这条边与that边比较
	public int compareTo(Edge that)
	{
		if(this.weight() < that.weight())
			return -1;
		else if(this.weight() > that.weight())
			return +1;
		else
			return 0;
	}
	
	//	对象的字符串表示
	public String toString()
	{
		return String.format("%d - %d, %.2f", v, w, weight);
	}
}
