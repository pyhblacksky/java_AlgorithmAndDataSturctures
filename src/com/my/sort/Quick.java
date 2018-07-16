package com.my.sort;
import com.algs.api.*;

public class Quick {
	
	public static void sort(Comparable[] a)
	{
		// 打乱顺序，防止影响，保持随机性,尽量避免糟糕的切分
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		// 对快排进行优化，在小数组上其速度低于插入算法，故在此优化，可使用插入算法
		if(lo >= hi)
		{
			Insertion.sort(a);
			return;
		}
		int j = partition(a, lo, hi); //	j为切分元素值
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
		
	private static int partition(Comparable[] a, int lo, int hi)
	{
		//	将数组分为三个部分
		int i = lo;
		int j = hi + 1;
		//	取第一个元素为关键元素
		Comparable v = a[lo];
		while(true)
		{
			//  满足a[++i] < v 此时继续移动i
			while(less(a[++i], v))
				if(i >= hi)
					break;
			//  满足a[--j] > v 此时继续移动i
			while(less(v, a[--j]))
				if(j <= lo)
					break;
			//	为了防止扫描越界！
			if(i >= j)
				break;
			// 经过以上条件筛选，交换a[i],a[j] 
			exch(a, i, j);
		}
		//	所占位置交换，此时j左边的全比j小，右边的全比j大
		exch(a, lo, j);
		return j;
		
	}
	
	
	private static boolean isSort(Comparable[] a)
	{
		for(int i = 1; i < a.length; i++)
		{
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		//	v < w  return -1
		return v.compareTo(w) <= 0;
	}
	
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable temp = a[i];
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
