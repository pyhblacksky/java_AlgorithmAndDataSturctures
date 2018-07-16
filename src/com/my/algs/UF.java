package com.my.algs;

/*
 *  function: ʵ�ֶ�̬����
 * 	author:pyh
 * 	data:2018.7.10
 * 	version: 1.0	
 * 
 * 	�����������
 * */


public class UF {
	private int[] id;
	private int count;
	
	// ��������ʶ(0��N-1)��ʼ��N����
	public UF(int N)
	{
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
	
	// ���p��q������ͬһ���������򷵻�true
	public boolean connected(int p, int q)
	{
		return find(p)== find(q);
	}
	
	
	// ��ͨ����������
	public int count()
	{
		return count;
	}
	
	/*
	 * Use quick-find
	 * 
	 * */
	// p���ڵķ����ı�ʶ��,�ж��ַ���
	public int find(int p)
	{
		return id[p];
	}
	
	// ��p��q֮�����һ������
	public void union(int p, int q)
	{
		// ��p��q�鲢����ͬ�ķ�����
		int qID = find(q);
		int pID = find(p);
		
		// ���p��q�Ѿ���ͬһ�����У��򲻲�ȡ�ж�
		if(qID == pID) return;
		
		// ��p�ķ���������Ϊq������
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
