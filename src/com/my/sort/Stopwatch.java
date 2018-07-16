package com.my.sort;

/*
 *	简单的计时器
 * 
 * */

public class Stopwatch {
	private final long start;
	public Stopwatch()
	{
		start = System.currentTimeMillis();
	}
	public double elapsedTime()
	{
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
	
}
