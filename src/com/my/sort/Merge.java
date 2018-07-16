package com.my.sort;
import com.algs.api.*;

/**
 * 实现归并排序
 * 
 * 
 * */

public class Merge {
	
	// 归并排序所需的辅助数组
		private static Comparable[] aux;
		
		// 向外调用函数
		public static void sort(Comparable[] a)
		{
			int N = a.length;
			aux = new Comparable[N];
			// 自底向上方法
			/*for(int sz = 1; sz < N; sz = sz+sz)
			{
				for(int lo = 0; lo < N-sz; lo += sz+sz)
					merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
			}
			*/
			// 自顶向下
			sort(a, 0 , N-1);
		}
		
		//	内部实现函数
		private static void sort(Comparable[] a, int lo, int hi)
		{
			if(hi <= lo)
				return;
			int mid = lo + (hi - lo) / 2;
			
			//	排序左边
			sort(a, lo, mid);
			//	排序右边
			sort(a, mid+1, hi);
			//	归并结果
			merge(a, lo, mid, hi);
			
		}
		
		// 归并操作
		public static void merge(Comparable[] a, int lo, int mid, int hi)
		{
			//	将a[lo..mid]和 a[mid+1..hi] 两组数组归并
			int i = lo;
			int j = mid + 1;
			//	将a[lo..hi]复制到aux[lo..hi]
			//	!!!!如果循环中 取 k < hi， 则会报错
			for(int k = lo; k <= hi; k++)
				aux[k] = a[k];
			for(int k = lo; k <= hi; k++)
			{
				// 左半边用尽
				if(i > mid)
					a[k] = aux[j++];
				//	右半边用尽
				else if(j > hi)
					a[k] = aux[i++];
				//	左半边的当前元素小于右半边的当前元素
				else if(less(aux[j], aux[i]))
					a[k] = aux[j++];
				//	右半边的当前元素大于等于左半边当前元素
				else
					a[k] = aux[i++];
			}
		}
	
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) <= 0;
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
