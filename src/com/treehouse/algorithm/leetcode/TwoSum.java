package com.treehouse.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述:
 *    给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 	     你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TwoSum {
	
	/**
	 * @Description 两数和(暴力破解法)
	 * @param arr 目标数组
	 * @param target 目标值
	 * @return
	 * @throws
	 */
	public static int[] twoSum(int[] nums, int target){
		
		int n = nums.length;
		int temp = 0;
		
		for(int i = 0; i < n - 1; i++){
			temp = target - nums[i];
			for(int j = i + 1; j < n; j++){
				if(nums[j] == temp){
					return new int[]{i,j};
				}
			}
		}
		
		return new int[0];
	}
	
	/**
	 * @Description 两数和(哈希表法)
	 * @param nums
	 * @param target
	 * @return
	 * @throws
	 */
	public static int[] twoSum2(int[] nums, int target){
		
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++){
			if(hash.containsKey(target - nums[i])){
				return new int[]{hash.get(target - nums[i]) , i};
			}
			
			hash.put(nums[i], i);
		}
		
		return new int[0];
	}
	
	public static void main(String[] args){
		
		long start = System.currentTimeMillis();
		int[] indices = twoSum2(new int[]{-1,5,8,10}, 9);
		long end = System.currentTimeMillis();
		
		//输出执行时间
		System.out.println("执行时间[" +(end - start) +  "]毫秒");
		
		//输出执行结果
		System.out.print("执行结果[");
		for(int i = 0; i < indices.length; i++){
			if(i == indices.length - 1){
				System.out.print(indices[i]);
			}else{
				System.out.print(indices[i] + ",");
			}
		}
		System.out.println("]");
	}
}
