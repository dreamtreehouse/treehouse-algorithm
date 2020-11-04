package com.treehouse.algorithm.findsort.sort;

import com.treehouse.algorithm.util.PrintUtil;

/**
 * 算法：插入排序
 * 思路：
 * 	1.将待排序序列的第一个元素看做一个有序序列，第二个元素到末尾元素看做未排序序列。
 * 	2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置(从后向前扫描有序序列，比较待排序元素与有序序列元素的大小，直到找到比待排序元素小的元素停止)。
 * 	3.如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。
 */
public class InsertionSort {
	
	public static int[] insertionSort(int[] arr){
		
		int len = arr.length;
		
		//循环待排序的序列
		for(int i = 1; i < len; i++){
			
			//待排序的元素
			int key = arr[i];
			
			//循环已排序的序列直到找到比key值小的元素
			int j = i - 1;
			while(j >= 0 && arr[j] > key){
				//若已排序数组中元素比key大,则向后移动
				arr[j+1] = arr[j];
				j--;
			}
			
			//将key插入比key小的元素的后一个位置,即j+1
			arr[j + 1] = key;
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{9,2,3,8,1,7,6,4,5};
		PrintUtil.printArray(insertionSort(arr));
	}
}
