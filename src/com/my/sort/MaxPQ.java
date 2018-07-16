package com.my.sort;
import com.algs.api.*;

/*
 *	基于堆实现优先队列！
 * 	不使用pq[0]
 * 	仅使用pq[1..N]
 * */

public class MaxPQ<Key extends Comparable> {
	
	private Key[] pq;
	private int N = 0;
	
	// 构建MaxPQ数组
	public MaxPQ(int maxN)
	{
		pq = (Key[]) new Comparable[maxN + 1];
	}
	
	//	比较  pq[i] < pq[j] 则返回真
	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0; 
	}
	
	//	返回大小
	public int Size()
	{
		return N;
	}
	
	//	判断是否为空
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	//	交换位置： pq[i]   pq[j]
	private void exch(int i, int j)
	{
		Key temp;
		temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	//	插入元素
	public void insert(Key a)
	{
		//	不使用pq[0]
		N++;
		pq[N] = a;
		swim(N);
	}
	
	//	删除最大元素并返回值
	public Key delMax()
	{
		Key max = pq[1];		
		exch(1, N);
		N--;
		//	防止对象游离, 回收空间
		pq[N + 1] = null;
		sink(0);
		return max;
	}
	
	//	上浮操作
	private void swim(int k)
	{
		while(k > 1 && less(k/2, k))
		{
			exch(k / 2, k);
			k = k / 2;
		}
	}
	
	//	下沉操作
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
