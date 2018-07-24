package com.my.graph;

import com.algs.api.In;
import com.algs.api.ST;

/*
 * 	有向图的符号表
 * 
 * */

public class SymbolDigraph {
	
	private ST<String, Integer> st;					//	符号名->索引
	private String[] keys;							//	索引->符号名
	private Digraph G;								//	图
	
	//	构造函数
	public SymbolDigraph(String stream, String sp)
	{
		st = new ST<String, Integer>();
		In in = new In(stream);						//	第一遍
		
		while(in.hasNextLine())						//	构造索引
		{
			String[] a = in.readLine().split(sp);	//	读取字符串
			for(int i = 0; i < a.length; i++)		//	为每个不同的字符串关联一个索引
			{	
				if(st.contains(a[i]))
				{
					st.put(a[i], st.size());
				}
			}
		}
		
		keys = new String[st.size()];				//	用来获得顶点名的反向索引是一个数组
		
		for(String name : st.keys())
			keys[st.get(name)] = name;
		
		G = new Digraph(st.size());					//	第二遍,含有st.size()个顶点的图
		in = new In(stream);						//	构造图
		while(in.hasNextLine())
		{
			//	将每一行的第一个顶点和该行的其他顶点相连
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1; i < a.length; i++)
			{
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	
	//	是否包含s
	public boolean contains(String s)
	{
		return st.contains(s);
	}
	
	//	返回s的索引
	public int index(String s)
	{
		return st.get(s);
	}
	
	//	返回索引对应的name
	public String name(int v)
	{
		return keys[v];
	}
	
	//	返回图
	public Digraph G()
	{
		return G;
	}
}
