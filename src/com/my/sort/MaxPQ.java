package com.my.sort;
import com.algs.api.*;

/*
 *	���ڶ�ʵ�����ȶ��У�
 * 	��ʹ��pq[0]
 * 	��ʹ��pq[1..N]
 * */

public class MaxPQ<Key extends Comparable> {
	
	private Key[] pq;
	private int N = 0;
	
	// ����MaxPQ����
	public MaxPQ(int maxN)
	{
		pq = (Key[]) new Comparable[maxN + 1];
	}
	
	//	�Ƚ�  pq[i] < pq[j] �򷵻���
	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0; 
	}
	
	//	���ش�С
	public int Size()
	{
		return N;
	}
	
	//	�ж��Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	//	����λ�ã� pq[i]   pq[j]
	private void exch(int i, int j)
	{
		Key temp;
		temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	//	����Ԫ��
	public void insert(Key a)
	{
		//	��ʹ��pq[0]
		N++;
		pq[N] = a;
		swim(N);
	}
	
	//	ɾ�����Ԫ�ز�����ֵ
	public Key delMax()
	{
		Key max = pq[1];		
		exch(1, N);
		N--;
		//	��ֹ��������, ���տռ�
		pq[N + 1] = null;
		sink(0);
		return max;
	}
	
	//	�ϸ�����
	private void swim(int k)
	{
		while(k > 1 && less(k/2, k))
		{
			exch(k / 2, k);
			k = k / 2;
		}
	}
	
	//	�³�����
	private void sink(int k)
	{
		while(N > 2*k)
		{
			int j = 2*k;
			if(j < N && less(j, j+1))
				j++;
			if(!less(k,j))
				break;
			exch(k,j);
			k = j;
		}
	}
	
	public void show()
	{
		for(int i = 1 ; i < N+1; i++)
		{
			StdOut.print(pq[i] + " ");
		}
		StdOut.println();
	}
	
}
