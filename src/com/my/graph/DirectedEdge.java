package com.my.graph;

/*
 * 	��Ȩ����ߵ���������
 * 	��չ��Digraph ��	
 * 
 * */

public class DirectedEdge {
	
	private final int v;			//	�ߵ����
	private final int w;			//	�ߵ��յ�
	private final double weight;	//	�ߵ�Ȩ��
	
	public DirectedEdge(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight()
	{
		return weight;
	}
	
	public int from()
	{
		return v;
	}
	
	public int to()
	{
		return w;
	}
	
	public String toString()
	{
		return String.format("%d -> %d %.2f", v, w, weight);
	}
	
}
