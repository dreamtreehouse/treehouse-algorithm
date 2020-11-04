package com.treehouse.algorithm.findsort.sort;

import com.treehouse.algorithm.util.PrintUtil;

/**
 * 算法：希尔排序
 * 思路：
 * 	1.选择一个增量序列t1，t2，... ，tk，其中ti > tj，tk=1。
 * 	2.按增量序列k，对序列进行k趟排序。
 * 	3.每趟排序，根据对应的增量ti，将待排序序列分割成若干长度为m的子序列，分别对各个子序列进行插入排序。
 */
public class ShellSort {
	
	public static int[] shellSort(int[] arr){
		
		//定义增量
		int len = arr.length;
		int step = len;
		
		while(step > 0){
			
			step = step / 2;
			
			//循环每一个分组,对每一个分组进行插入排序
			for(int k = 0; k < step; k++){
				//扫描待排序序列中的每一个元素
				for(int i = k + step; i < len; i = i + step){
					
					int key = arr[i];
					
					//扫描已排序的序列,找到待排序元素的位置
					int j = i - step;
					while(j >=0 && arr[j] > key){
						arr[j + step] = arr[j];
						j = j - step;
					}
					
					arr[j + step] = key;
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
		PrintUtil.printArray(shellSort(arr));
	}
}
