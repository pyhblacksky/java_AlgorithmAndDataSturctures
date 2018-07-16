package com.my.sort;
import com.algs.api.*;

/**
 * ʵ�ֹ鲢����
 * 
 * 
 * */

public class Merge {
	
	// �鲢��������ĸ�������
		private static Comparable[] aux;
		
		// ������ú���
		public static void sort(Comparable[] a)
		{
			int N = a.length;
			aux = new Comparable[N];
			// �Ե����Ϸ���
			/*for(int sz = 1; sz < N; sz = sz+sz)
			{
				for(int lo = 0; lo < N-sz; lo += sz+sz)
					merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
			}
			*/
			// �Զ�����
			sort(a, 0 , N-1);
		}
		
		//	�ڲ�ʵ�ֺ���
		private static void sort(Comparable[] a, int lo, int hi)
		{
			if(hi <= lo)
				return;
			int mid = lo + (hi - lo) / 2;
			
			//	�������
			sort(a, lo, mid);
			//	�����ұ�
			sort(a, mid+1, hi);
			//	�鲢���
			merge(a, lo, mid, hi);
			
		}
		
		// �鲢����
		public static void merge(Comparable[] a, int lo, int mid, int hi)
		{
			//	��a[lo..mid]�� a[mid+1..hi] ��������鲢
			int i = lo;
			int j = mid + 1;
			//	��a[lo..hi]���Ƶ�aux[lo..hi]
			//	!!!!���ѭ���� ȡ k < hi�� ��ᱨ��
			for(int k = lo; k <= hi; k++)
				aux[k] = a[k];
			for(int k = lo; k <= hi; k++)
			{
				// �����þ�
				if(i > mid)
					a[k] = aux[j++];
				//	�Ұ���þ�
				else if(j > hi)
					a[k] = aux[i++];
				//	���ߵĵ�ǰԪ��С���Ұ�ߵĵ�ǰԪ��
				else if(less(aux[j], aux[i]))
					a[k] = aux[j++];
				//	�Ұ�ߵĵ�ǰԪ�ش��ڵ������ߵ�ǰԪ��
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
