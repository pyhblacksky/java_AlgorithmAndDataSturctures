package com.my.strings;

/*
 * 	高位优先的字符串排序
 * 	(对于字符串长度不一定相同的数据进行排序)
 * 
 * */

public class MSD {
	
	private static int R = 256;			//	基数
	private static final int M = 15;	//	小数组的切换阈值
	private static String[] aux;		//	数据分类的辅助数组
	
	private static int charAt(String s, int d)
	{
		if(d < s.length())
			return s.charAt(d);
		else
			return -1;
	}
	
	public static void sort(String[] a)
	{
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N-1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d)
	{
		//	以第d个字符为键值将a[lo]至a[hi]进行排序
		if(hi <= lo + M)
		{
			insertion(a, lo, hi, d);
			return;
		}
		
		int[] count = new int[R+2];		//	计算频率
		for(int i = lo; i <= hi; i++)
			count[charAt(a[i], d) + 2]++;
		
		for(int r = 0; r < R + 1; r++)
			count[r+1] += count[r];		//	将频率转换为索引
		
		for(int i = lo; i <= hi; i++)	//	数据分类
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		
		for(int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];			//	回写
			
		//	递归的以每个字符为键值进行排序
		for(int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
	}
	
	/*****************************************************/
	//	所用的插入排序, 从第d个字符串开始
	private static void insertion(String[] a, int lo, int hi, int d)
	{
		for(int i = lo; i <= hi; i++)
			for(int j = i; j > lo && less(a[j], a[j-1], d); j--)
				exch(a, j, j-1);
	}
	
	//	交换a[i]和a[j]
	private static void exch(String[] a, int i, int j)
	{
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//	字符串比较操作，	从第d个字符串开始比较
	private static boolean less(String v, String w, int d)
	{
		for(int i = d; i < Math.min(v.length(), w.length()); i++)
		{
			if(v.charAt(i) < w.charAt(i))
				return true;
			if(v.charAt(i) > w.charAt(i))
				return false;
		}
		// 	字符串长度短的在前
		return v.length() < w.length();
	}
	
	/*****************************************************/
}
