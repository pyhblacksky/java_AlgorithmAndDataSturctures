package com.my.strings;

/*	
 * 关于键索引排序法(类似于分组排序后合并)：
 * 一、思想 

 * 适用于小整数键的简单排序方法；假设数组a[]中的每个元素都保存了一个名字和一个组号，其中组号在0到R-1之间，以组号为键进行分组排序； 

 * 二、步骤 

 * 频率统计：使用int数组计算每个键出现的频率； 

 * 将频率转换成索引：使用count[]来计算每个键在排序结果中的起始位置； 

 * 数据分类：将count[]数组转换成一张索引表后，将所有元素移动到一个辅助数组aux[]中以进行排序； 

 * 回写：将排序数组aux[]结果复制回原数组; 
 *	
 * 
 * 
 * 此处是低位优先的字符串排序
 * 
 * */

/*
 * 工作流程：将每个元素均为含有W个字符的字符串数组a[]排序，
 * 			要进行W此键索引计数排序：从右向左，
 * 			以每个位置的字符为键排序一次。
 * 
 * */

public class LSD {
	
	//	将a中每个元素含有W个字符的字符串进行排序
	public static void sort(String[] a, int W)
	{
		//	通过前W个字符将a[]排序
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for(int d = W - 1; d >= 0; d--)
		{
			//	根据第d个字符用键索引计数法进行排序
			int[] count = new int[R+1];		
			
			for(int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++;			//	计算出现频率
			
			for(int r = 0; r < R; r++)
				count[r+1] += count[r];					//	将频率转换为索引
			
			for(int i = 0; i < N; i++)
				aux[count[a[i].charAt(d)]++] = a[i];	//	将元素分类
			
			for(int i = 0; i < N; i++)
				a[i] = aux[i];							//	回写
			
		}
	}
	
}
