package com.test.demo;

public class NessaryComputing {
	// ����һ�������ľ���ֵ
	public static int abs(int num)
	{
		return num <= 0 ? -num : num;
	}
	
	// ����һ���������ľ���ֵ
	public static double abs(double num)
	{
		return num <= 0? -num : num;
	}
	
	// �ж�һ�����Ƿ�Ϊ����
	public static boolean isPrime(int num)
	{
		if (num <= 2) return true;
		
		for(int i = 2; i*i <= num; i++)
		{
			if (num % i == 0) return false;
		}
		
		return true;
	}
	
	// ����ƽ������ţ�ٵ�������
	public static double sqrt(double num)
	{
		if(num < 0) return Double.NaN;
		double err = 1e-15;
		double temp = num;
		while(Math.abs(temp - num/temp) > err*temp)
			temp = (num/temp + temp) / 2.0;
		return temp;
	}
	
	// ����������б��
	public static double hypotenuse(double a, double b)
	{
		return Math.sqrt(a*a+b*b);
	}
	
	//������ͺ���
	public static double H(int num)
	{
		double sum = 0.0;
		for(int i = 0; i <= num; i++)
			sum += 1.0/i;
		return sum;
	}
	
}
