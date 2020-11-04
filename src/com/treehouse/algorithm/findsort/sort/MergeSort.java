package com.treehouse.algorithm.findsort.sort;

import com.treehouse.algorithm.util.PrintUtil;

/**
 * 算法：归并排序
 * 思路： 
 * 	1.申请空间，使其大小为两个有序序列之和，该空间用来存放合并后的序列。
 * 	2.设定两个指针，最初位置分别为两个已经排序序列的起始位置。
 * 	3.比较两个指针所指向的元素，选择相对较小的元素放入到合并空间，并移动指针到下一位置。
 * 	4.重复步骤3直到某一指针达到序列尾。
 * 	5.将另一序列剩下的所有元素直接复制到合并序列尾。
 */
public class MergeSort {
	
	public static int[] mergeSort(int[] arr, int low, int high){
		
		if(arr == null || arr.length == 0)
			return new int[]{};
		
		int mid = (low + high) / 2;
		
		if(low < high){
			//对序列左半部分进行归并
			mergeSort(arr, low, mid);
			//对序列右半部分进行归并
			mergeSort(arr, mid + 1, high);
			//对左右两半部分进行合并
			merge(arr, low, mid, high);
		}
		
		return arr;
	}
	
	public static void merge(int[] arr, int low, int mid, int high){
		
		int temp[] = new int[high - low + 1];
		
		int i = low;	//A[i]为第一个序列,下标为i~mid.
		int j = mid + 1;//B[j]为第二个序列,下标为mid+1~high.
		int k = 0;		//临时数组下标
		
		//循环比较A[i]和B[j]的元素，并按顺序放入temp[]中.
		while(i <= mid && j <= high){
			if(arr[i] < arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
			}
		}
		
		//将A[i]中多余的元素直接放入temp[]中.
		while(i <= mid){
			temp[k++] = arr[i++];
		}
		
		//将B[i]中多余的元素直接放入temp[]中.
		while(j <= high){
			temp[k++] = arr[j++];
		}
		
		//将temp[]中的元素原位置覆盖至原数组中
		for(int x = 0; x < temp.length; x++){
			arr[low + x] = temp[x];
		}
	}
	
	public static void main(String[] args){
		
		int[] arr = new int[]{9,2,3,8,1,7,6,4,5};
		
		System.out.print("排序前：");
		PrintUtil.printArray(arr);
		
		System.out.print("排序后：");
		PrintUtil.printArray(mergeSort(arr,0,arr.length - 1));
	}
}
