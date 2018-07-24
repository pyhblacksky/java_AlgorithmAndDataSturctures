package com.my.graph;

import com.algs.api.Stack;

/*
 * 	Ѱ������	
 * 
 * 	�����޻�ͼ�����������򻷵�����ͼ
 * 	����������򻷣����Լ������������Ƿ����ʵ��
 * 	Ӧ�ýϹ�
 * 
 * */

public class DirectedCycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;	//	��¼�����е����ж���(�������)
	private boolean[] onStack;		//	�ݹ����ջ�ϵ����ж���
	
	public DirectedCycle(Digraph G)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
		{
			dfs(G, v);		//	��ͼ��ÿһ������м��
		}
		
	}
	
	private void dfs(Digraph G, int v)
	{
		onStack[v] = true;
		marked[v] = true;		//	�����һ��ѭ�����
		for(int w : G.adj(v))
		{
			if(hasCycle())
				return;
			else if(!marked[w])
			{
				edgeTo[w] = v;	//	������һ�ξ����ĵ�
				dfs(G, w);
			}
			else if(onStack[w])	//	��⵽��ǰ����ڽӵ�Ϊ�ѱ�ǹ��ĵ㣬����ջ���ؼ����裩
			{
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
				{
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle()
	{
		return cycle != null;
	}
	
	public Iterable<Integer> cycle()
	{
		return cycle;
	}
}
