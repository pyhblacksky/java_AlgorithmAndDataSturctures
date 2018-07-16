package com.my.sort;
import com.algs.api.*;

public class Quick {
	
	public static void sort(Comparable[] a)
	{
		// ����˳�򣬷�ֹӰ�죬���������,�������������з�
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		// �Կ��Ž����Ż�����С���������ٶȵ��ڲ����㷨�����ڴ��Ż�����ʹ�ò����㷨
		if(lo >= hi)
		{
			Insertion.sort(a);
			return;
		}
		int j = partition(a, lo, hi); //	jΪ�з�Ԫ��ֵ
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
		
	private static int partition(Comparable[] a, int lo, int hi)
	{
		//	�������Ϊ��������
		int i = lo;
		int j = hi + 1;
		//	ȡ��һ��Ԫ��Ϊ�ؼ�Ԫ��
		Comparable v = a[lo];
		while(true)
		{
			//  ����a[++i] < v ��ʱ�����ƶ�i
			while(less(a[++i], v))
				if(i >= hi)
					break;
			//  ����a[--j] > v ��ʱ�����ƶ�i
			while(less(v, a[--j]))
				if(j <= lo)
					break;
			//	Ϊ�˷�ֹɨ��Խ�磡
			if(i >= j)
				break;
			// ������������ɸѡ������a[i],a[j] 
			exch(a, i, j);
		}
		//	��ռλ�ý�������ʱj��ߵ�ȫ��jС���ұߵ�ȫ��j��
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
