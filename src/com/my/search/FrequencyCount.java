package com.my.search;
import com.algs.api.*;

/*
 *	Ƶ�ʼ���
 *	�ظ��ֶ�ͳ�Ƽ��� 
 * 
 * 	Ҫ��ʵ��ST�Ļ����ϲ�����������
 * */

public class FrequencyCount {
	public static void main(String[] args)
	{
		int minlen = Integer.parseInt(args[0]);
		
		SimpleST<String, Integer> st;
		st = new SimpleST<String, Integer>(10);
		
		while(!StdIn.isEmpty())
		{
			//	������ű�ͳ��Ƶ��
			String word = StdIn.readString();
			//	���Խ϶̵ĵ���
			if(word.length() < minlen)
				continue;
			if(!st.contains(word))
				st.put(word, 1);
			else
				st.put(word, st.get(word) + 1);
		}
		
		//	�ҳ�����Ƶ����ߵĵ���
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
