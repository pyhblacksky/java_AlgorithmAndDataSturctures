package com.my.graph;

import com.algs.api.StdOut;

/*
 * 	ʵ����������
 * 	
 * 	һ�������޻�ͼ������˳��Ϊ���ж�������������
 * 
 * */

public class Topological {
	
	private Iterable<Integer> order;	//	�������������
	
	public Topological(Digraph G)
	{
		DirectedCycle cycleFinder = new DirectedCycle(G);
		if(!cycleFinder.hasCycle())		//	���������򻷣���ִ��
		{
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	
	//	�Ƿ�Ϊ�����޻�ͼ
	public boolean isDAG()
	{
		return order != null;
	}
	
	public Iterable<Integer> order()
	{
		return order;
	}
	
	//	�������ó���
	public static void main(String[] args)
	{
		String filename = args[0];
		String separator = args[1];
		SymbolDigraph sg = new SymbolDigraph(filename, separator);
		
		Topological top = new Topological(sg.G());
		
		for(int v : top.order())
			StdOut.println(sg.name(v));		
	}
	
}
