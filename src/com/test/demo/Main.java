package com.test.demo;
import com.test.demo.*;
import java.util.Arrays;
import com.algs.api.*;
import com.my.algs.*;
import com.my.search.BinarySearchST;
import com.my.search.SequentialSearchST;
import com.my.sort.*;

public class Main {
	// 必须加上 Strings[] args ,否则找不到入口
	public static void main(String[] args)
	{
		// 测试一些自写函数
		double a = 5.2513;
		System.out.println(NessaryComputing.sqrt(a));
		
		// 测试二分查找
		int[] whitelist = {5,2,4,5,8,7,4,1,3};
		Arrays.sort(whitelist);
				
		for(int i = 0; i < whitelist.length; i++)
		{
			System.out.print(whitelist[i]+" ");
		}
		System.out.println();
					
		int result_rank = BinarySearch.rank(6, whitelist);
		System.out.println(result_rank);
		
		// 测试StdOut 包是否正常调用
		StdOut.println("test StdOut");
		
		// 测试背包
		/*
		Bag<Double> bags = new Bag<Double>();
		while(!StdIn.isEmpty())
		{
			bags.add(StdIn.readDouble());
		}
		int N_bags = bags.size();
		
		double sum_bags = 0.0;
		for(double x : bags)
		{
			sum_bags += x;
		}
		double Mean_bags = sum_bags/N_bags;
		StdOut.println("Sum of Bag: "+sum_bags);
		StdOut.println("Mean of Bag: "+Mean_bags);
		*/
		
		// 测试队列
		Queue<Double> queues = new Queue<Double>();
		StdOut.println(queues.isEmpty());
		queues.enqueue(50.2);
		queues.enqueue(601.4);
		for(double x : queues)
			StdOut.print(x+" ");
		StdOut.println();
		queues.dequeue();
		for(double x : queues)
			StdOut.print(x+" ");
		StdOut.println();
		
		//  测试自写数据结构
		myStack<Double> mystack = new myStack<Double>();
		mystack.push(55.2);
		mystack.push(775.123);
		mystack.push(166641.1);
		mystack.pop();
		for(double x : mystack)
		{
			System.out.print(x + " ");
		}
		System.out.println();
		
		myBag<Double> mybag = new myBag<Double>();
		mybag.add(12.3);
		for(double x : mybag)
		{
			System.out.println(x);
		}
		myQueue<Double> myqueue = new myQueue<Double>();
		myqueue.enQueue(995.4);
		myqueue.enQueue(32.41);
		myqueue.enQueue(5451.1);
		myqueue.deQueue();
		for(double x : myqueue)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
		//  测试双向链表,有问题
		myDeque<Double>  mydeque = new myDeque<Double>();
		mydeque.pushLeft(40.2);
		mydeque.pushRight(11.1);
		for(double x : mydeque)
		{
			System.out.println(x);
		}
		
		//	测试排序
		Comparable[] sort_selection_one = {52.01,99.4,15.4,77.5,64.5,5.7,8.7,56.1};
		Selection.sort(sort_selection_one);
		Selection.show(sort_selection_one);
		
		Comparable[] sort_selection_two = {'b','d','k','h','c','g','q','z','a','y','u','i','e'};
		Quick3Way.sort(sort_selection_two);
		Quick3Way.show(sort_selection_two);
		
		// 比较排序算法运算速度
		/*
		int N_ = 500;
		int T_ = 6000;
		double t1 = SortCompare.timeRandomInput("Insertion", N_, T_);
		double t2 = SortCompare.timeRandomInput("Selection", N_, T_);
		//StdOut.printf("For %d ramdom Doubles \n %s is ", N_,);
		StdOut.printf("%.1f times faster than %s\n", t2/t1, "Insertion");
		*/
		
		//	测试优先队列
		MaxPQ<Comparable> maxpq = new MaxPQ<>(10);
		maxpq.insert(10.1);
		maxpq.insert(5.2);
		maxpq.insert(99.8);
		maxpq.insert(45.7);
		maxpq.show();

		Comparable[] sort_selection_three = {'b','d','k','h','c','g','q','z','a','y','u','i','e'};
		Heap.sort(sort_selection_three);
		Heap.show(sort_selection_three);
		
		//	测试顺序查找
		SequentialSearchST<String, Integer> SST = new SequentialSearchST<String, Integer>();
		SST.put("a", 1);
		SST.put("b", 2);
		SST.put("c", 3);
		SST.put("d", 4);
		SST.put("e", 5);
		SST.put("f", 6);
		
		SST.show();
		StdOut.println(SST.get("a"));
		
		//	测试二分查找表
		BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>(10);
		binarySearchST.put("a", 1);
		binarySearchST.put("b", 2);
		binarySearchST.put("c", 3);
		binarySearchST.put("d", 4);
		binarySearchST.put("e", 5);
		binarySearchST.put("f", 6);
		StdOut.println("二分查找表：");
		StdOut.println(binarySearchST.size());
		binarySearchST.show();
		binarySearchST.delete("b");
		binarySearchST.show();
		StdOut.println(binarySearchST.min()+"  get:"+ binarySearchST.get("e"));
	}
}
