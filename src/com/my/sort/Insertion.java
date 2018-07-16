package com.my.sort;
import java.util.Comparator;

import com.algs.api.*;

/**
 * 实现插入排序
 * 
 * 
 * */

public class Insertion {
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		// 从摸到的第二张牌开始进行插入
		for(int i = 1; i < N; i++)
		{
			for(int j = i; j > 0 && less(a[j], a[j-1]); j--)
				exch(a,j,j-1);
		}
	}
	
	//	多建数组
	private static boolean less(Comparator c, Object v, Object w)
	{
		return c.compare(v, w) <= 0;
	}
	
	private static void exch(Object[] c, int i, int j)
	{
		Object temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	
	public static void sort(Object[] a, Comparator c)
	{
		int N = a.length;
		
		for(int i = 1; i < N; i++)
		{
			for(int j = i; j > 0 && less(c, a[j-1], a[j]) ; j++)
				exch(a, j-1, j);
		}
		
	}
	//
	
	
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
