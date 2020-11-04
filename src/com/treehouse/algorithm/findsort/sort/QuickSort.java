package com.treehouse.algorithm.findsort.sort;

import com.treehouse.algorithm.util.PrintUtil;

/**
 * 算法：快速排序
 * 思路：
 * 	1.从待排序数列中挑出一个元素，称为“基准”。
 * 	2.重新排序数列，所有元素比基准值小的摆放到基准前面，所有元素比基准值大的摆放在基准值后面。
 * 	3.递归的对小于基准值的序列和大于基准值的序列分别进行快速排序。
 */
public class QuickSort {
	
	public static int[] quickSort(int[] arr, int start, int end){
		
		if(arr == null || arr.length == 0)
			return new int[]{};
		
		int i = start, j = end;
		int key = arr[i];
		
		while(i < j){
			
			//从后向前搜索找到比key小的元素
			while(i < j && arr[j] > key){
				j--;
			}
			
			if(i < j){
				arr[i] = arr[j];
				i++;
			}
			
			//从前向后搜索找到比key大的元素
			while(i < j && arr[i] < key){
				i++;
			}
			
			
			if(i < j){
				arr[j] = arr[i];
				j--;
			}
		}
		
		//i == j
		arr[i] = key;
		
		//对小于key的序列进行快排
		if(i > start){
			quickSort(arr, start, i - 1);
		}
		
		//对大于key的序列进行快排
		if(j + 1 < end){
			quickSort(arr, j + 1, end);
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		
		int[] arr = new int[]{9,2,3,8,1,7,6,4,5};
		
		System.out.print("排序前：");
		PrintUtil.printArray(arr);
		
		System.out.print("排序后：");
		PrintUtil.printArray(quickSort(arr, 0, arr.length - 1));
	}
}
