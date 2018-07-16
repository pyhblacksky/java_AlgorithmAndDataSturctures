package com.test.demo;

public class NessaryComputing {
	// 计数一个整数的绝对值
	public static int abs(int num)
	{
		return num <= 0 ? -num : num;
	}
	
	// 计算一个浮点数的绝对值
	public static double abs(double num)
	{
		return num <= 0? -num : num;
	}
	
	// 判定一个数是否为素数
	public static boolean isPrime(int num)
	{
		if (num <= 2) return true;
		
		for(int i = 2; i*i <= num; i++)
		{
			if (num % i == 0) return false;
		}
		
		return true;
	}
	
	// 计算平方根（牛顿迭代法）
	public static double sqrt(double num)
	{
		if(num < 0) return Double.NaN;
		double err = 1e-15;
		double temp = num;
		while(Math.abs(temp - num/temp) > err*temp)
			temp = (num/temp + temp) / 2.0;
		return temp;
	}
	
	// 计算三角形斜边
	public static double hypotenuse(double a, double b)
	{
		return Math.sqrt(a*a+b*b);
	}
	
	//计算调和函数
	public static double H(int num)
	{
		double sum = 0.0;
		for(int i = 0; i <= num; i++)
			sum += 1.0/i;
		return sum;
	}
	
}
