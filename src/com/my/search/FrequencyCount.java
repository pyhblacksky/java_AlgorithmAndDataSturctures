package com.my.search;
import com.algs.api.*;

/*
 *	频率计算
 *	重复字段统计计算 
 * 
 * 	要在实现ST的基础上才能正常运行
 * */

public class FrequencyCount {
	public static void main(String[] args)
	{
		int minlen = Integer.parseInt(args[0]);
		
		SimpleST<String, Integer> st;
		st = new SimpleST<String, Integer>(10);
		
		while(!StdIn.isEmpty())
		{
			//	构造符号表并统计频率
			String word = StdIn.readString();
			//	忽略较短的单词
			if(word.length() < minlen)
				continue;
			if(!st.contains(word))
				st.put(word, 1);
			else
				st.put(word, st.get(word) + 1);
		}
		
		//	找出出现频率最高的单词
		String max = " ";
		st.put(max, 0);
		for(String word : st.keys())
		{
			if(st.get(word) > st.get(max))
				max = word;
		}
		StdOut.println(max + " " + st.get(max));
	}
}
