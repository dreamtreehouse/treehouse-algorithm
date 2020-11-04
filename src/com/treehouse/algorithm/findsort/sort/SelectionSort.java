package com.treehouse.algorithm.findsort.sort;

import com.treehouse.algorithm.util.PrintUtil;

/**
 * 算法：选择排序
 * 思路：
 * 	1.首先在未排序序列中找出最小(大)的元素，存放到排序序列的起始位置。
 * 	2.再从剩余未排序元素中继续寻找最小(大)元素，然后放到已排序序列的末尾。
 * 	3.重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {
	
	public static int[] selectionSort(int[] arr){
		
		int len = arr.length;
		
		for(int i = 0; i < len - 1; i++){
			
			int min = i;
			
			for(int j = i + 1; j < len; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			
			if(min != i){
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{9,2,3,8,1,7,6,4,5};
		PrintUtil.printArray(selectionSort(arr));
	}
}
