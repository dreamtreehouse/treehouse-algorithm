package com.treehouse.algorithm.findsort.sort;

import com.treehouse.algorithm.util.PrintUtil;

/**
 * 算法：计数排序
 * 思路：
 * 	1.花O(n)的时间扫描一下待排序数列arr，获取其最小值min和最大值max。
 * 	2.开辟一块新的空间创建新的数组c，长度为（max - min + 1）。
 * 	3.遍历arr，计算arr中每个元素出现的次数，并存到对应的c[n]的位置，n=arr[i]-min。
 * 	4.遍历c，计算出arr中元素出现在最终序列中的第几个位置，并存入对应的c[n]中。
 * 	5,新建一个同arr大小一致的数组b，遍历arr，根据arr[i]在c[n]中出现的位置，将arr[i]放入b中。
 */
public class CountingSort {
	
	public static int[] countingSort(int[] arr){
		
		if(arr == null || arr.length == 0)
			return new int[]{};
		
		//获取arr中的最大值和最小值
		int max = arr[0], min = arr[0];
		for(int a : arr){
			if(a > max){
				max = a;
			}
			
			if(a < min){
				min = a;
			}
		}
		
		int[] a = new int[max - min + 1];
		
		//遍历arr,计算arr[i]出现的次数，并存放到对应的a[index]中,index=arr[i]-min
		for(int i = 0; i < arr.length; i++){
			int index = arr[i] - min;
			a[index] = a[index] + 1;
		}
		
		//遍历a,计算arr[i]位于最终序列中的位置，再次存入a[index]中.
		for(int i = 1; i < a.length; i++){
			a[i] = a[i] + a[i - 1];
		}
		
		
		//遍历arr,按照arr[i]在a[index]中出现的位置，将arr中的元素放入b[n]中.
		int[] b= new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			int index = arr[i] - min;
			a[index] = a[index] - 1;
			b[a[index]] = arr[i];
		}
		
		return b;
	}
	
	public static void main(String[] args){
		
		int[] arr = new int[]{ 7, 7, 3, 7, 6, 2, 2, 9, 5 };

		System.out.print("排序前：");
		PrintUtil.printArray(arr);
		
		System.out.print("排序后：");
		PrintUtil.printArray(countingSort(arr));
	}
}
