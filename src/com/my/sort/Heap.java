package com.my.sort;
import com.algs.api.*;

/*
 *	堆排序，主要利用下沉排序
 * 	目前存在问题！！！   
 * 	尚未解决！！！！！
 * */

public class Heap {
	
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		//	构造堆
		for(int k = N/2; k >= 0; k--)
		{
			sink(a, k, N);
		}
		//	在下沉排序中销毁堆
		while(N > 0)
		{
			exch(a, 0, --N);
			sink(a, 0, N);
		}
	}
	
	private static void sink(Comparable[] a, int k, int N)
	{
		while( N > k*2)
		{
			int j = k*2;
			if(k == 0)
				j = 2;
			if( j < N && less(a[j-1], a[j]))
				j++;
			if(!less(a[k],a[j]))
				break;
			exch(a, k, j);
			k = j;
		}
	}
	
	private static boolean isEmpty()
	{
		return true;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a , int i , int j)
	{
		Comparable temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
}
