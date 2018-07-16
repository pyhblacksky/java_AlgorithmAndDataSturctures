package com.my.algs;

/*
 *  function: 实现动态连接
 * 	author:pyh
 * 	data:2018.7.10
 * 	version: 1.0	
 * 
 * 	测试情况：无
 * */


public class UF {
	private int[] id;
	private int count;
	
	// 以整数标识(0到N-1)初始化N个点
	public UF(int N)
	{
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
	
	// 如果p和q存在于同一个分量中则返回true
	public boolean connected(int p, int q)
	{
		return find(p)== find(q);
	}
	
	
	// 连通分量的数量
	public int count()
	{
		return count;
	}
	
	/*
	 * Use quick-find
	 * 
	 * */
	// p所在的分量的标识符,有多种方法
	public int find(int p)
	{
		return id[p];
	}
	
	// 在p和q之间添加一条连接
	public void union(int p, int q)
	{
		// 将p和q归并到相同的分量中
		int qID = find(q);
		int pID = find(p);
		
		// 如果p和q已经在同一分量中，则不采取行动
		if(qID == pID) return;
		
		// 将p的分量重命名为q的名称
		for(int i = 0; i < id.length; i++)
		{
			if(id[i] == pID)
				id[i] = qID;
			count--;
		}
	}
	
	/*
	 * Use quick-union
	 * 
	 * */
	
	
}
