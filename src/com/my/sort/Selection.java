package com.my.sort;
import com.algs.api.*;

public class Selection {

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
		{
			int min = i;
			for(int j = i + 1; j < N; j++)
			{
				if(less(a[j], a[min]))
					min = j;
			}
			exch(a, min, i);
		}
	}
	
	// 若 v < w ,返回真
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	// 交换 ,序号交换
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// 有序，返回true
	private static boolean isSorted(Comparable[] a)
	{
		for(int i = 1; i < a.length; i++)
		{	
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	// 输出结果
	public static void show(Comparable[] a)
	{
		//  在单行中打印数组
		for(int i = 0; i < a.length; i++)
		{
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
}
