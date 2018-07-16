package com.test.demo;

public class BinarySearch {
	// 数组必须是有序的, 返回值是该元素在数组中的序号
	public static int rank(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length - 1;
		// 查找值要么不存在，要么一定位于lo和hi之间
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
