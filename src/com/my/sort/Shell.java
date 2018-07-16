package com.my.sort;
import com.algs.api.*;

public class Shell {

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		int h = 1;
		// 分组间隔
		while(h < N/3)
			h = 3*h + 1;
		while(h >= 1)
		{
			for(int i = h; i < N; i++)
			{
				//  将每一个h分组变为有序
				for(int j = i; j >=h && less(a[j], a[j-h]); j = j-h)
				{
					exch(a, j, j-h);
				}
			}
			h = h/3;
		}
	}
	
	private static boolean isSort(Comparable[] a)
	{
		int N = a.length;
		for(int i = 1; i < N; i++)
		{
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
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
		int N = a.length;
		for(int i = 0; i < N; i++)
		{
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
}
