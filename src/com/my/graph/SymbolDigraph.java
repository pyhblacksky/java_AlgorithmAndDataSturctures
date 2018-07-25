package com.my.graph;

import com.algs.api.In;
import com.algs.api.ST;

/*
 * 	����ͼ�ķ��ű�
 * 
 * */

public class SymbolDigraph {
	
	private ST<String, Integer> st;					//	������->����
	private String[] keys;							//	����->������
	private Digraph G;								//	ͼ
	
	//	���캯��
	public SymbolDigraph(String stream, String sp)
	{
		st = new ST<String, Integer>();
		In in = new In(stream);						//	��һ��
		
		while(in.hasNextLine())						//	��������
		{
			String[] a = in.readLine().split(sp);	//	��ȡ�ַ���
			for(int i = 0; i < a.length; i++)		//	Ϊÿ����ͬ���ַ�������һ������
			{	
				if(st.contains(a[i]))
				{
					st.put(a[i], st.size());
				}
			}
		}
		
		keys = new String[st.size()];				//	������ö������ķ���������һ������
		
		for(String name : st.keys())
			keys[st.get(name)] = name;
		
		G = new Digraph(st.size());					//	�ڶ���,����st.size()�������ͼ
		in = new In(stream);						//	����ͼ
		while(in.hasNextLine())
		{
			//	��ÿһ�еĵ�һ������͸��е�������������
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1; i < a.length; i++)
			{
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	
	//	�Ƿ����s
	public boolean contains(String s)
	{
		return st.contains(s);
	}
	
	//	����s������
	public int index(String s)
	{
		return st.get(s);
	}
	
	//	����������Ӧ��name
	public String name(int v)
	{
		return keys[v];
	}
	
	//	����ͼ
	public Digraph G()
	{
		return G;
	}
}