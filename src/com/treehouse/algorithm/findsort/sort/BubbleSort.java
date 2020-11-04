package com.treehouse.algorithm.findsort.sort;

import com.treehouse.algorithm.util.PrintUtil;

/**
 * 算法：冒泡排序
 * 思路：
 * 	1.比较相邻的两个元素，如果第一个比第二个大，就交换它们两个。
 * 	2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 	3.针对所有的元素重复以上的步骤，除了最后一个。
 * 	4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {
	
	public static int[] bubbleSort(int[] arr){
		
		int len = arr.length;
		
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len - 1 - i; j++){
				if(arr[j] > arr[j + 1]){
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		
		int[] arr = new int[]{9,2,3,8,1,7,6,4,5};
		
		System.out.print("排序前：");
		PrintUtil.printArray(arr);
		
		System.out.print("排序后：");
		PrintUtil.printArray(bubbleSort(arr));
	}
}
