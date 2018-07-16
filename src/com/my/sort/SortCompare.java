package com.my.sort;
import com.algs.api.*;

/*
 * 为了比较不同排序算法的效率
 * 
 * */

public class SortCompare {
	public static double time(String alg, Comparable[] a)
	{
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion"))	Insertion.sort(a);
		if(alg.equals("Selection"))	Selection.sort(a);
		if(alg.equals("Quick"))		Quick.sort(a);
		if(alg.equals("Quick3Way"))	Quick3Way.sort(a);
		if(alg.equals("Shell"))		Shell.sort(a);
		if(alg.equals("Merge"))		Merge.sort(a);
		
		return timer.elapsedTime();
	}
	
	// 使用算法alg将T个长度为N的数组排序
	public static double timeRandomInput(String alg, int N, int T)
	{
		double total = 0.0;
		Double[] a = new Double[N];
		for(int i = 0; i < T; i++)
		{
			// 随机生成数组 并排序
			for(int j = 0; j < N; j++)
				a[j] = StdRandom.uniform();
			total += time(alg, a);
		}
		
		return total;
	}
}
