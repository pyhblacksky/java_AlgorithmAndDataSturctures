package com.test.demo;

public class BinarySearch {
	// ��������������, ����ֵ�Ǹ�Ԫ���������е����
	public static int rank(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length - 1;
		// ����ֵҪô�����ڣ�Ҫôһ��λ��lo��hi֮��
		while(lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		
		}
		return -1;
	}
}
