package com.treehouse.algorithm.leetcode;

/**
 * 	问题描述：
 * 		给定一个整数数组nums，找到一个具有最大和的连续子数组(子数组最少包含一个元素),返回其最大和。
 * 	示例：
 * 		输入：[-2,1,-3,4,-1,2,1,-5,4]
 * 		输出：6
 * 		解释：连续子数组[4,-1,2,1]的和最大,为6
 * 	题解：
 */
public class MaxSubArray {
	
	/**
	 * @Description 暴力破解：求出所有子序和
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int nums[]) {
		
		if(nums == null || nums.length == 0)
			return 0;
		
		int len = nums.length;
		int max = nums[0];
		int[][] temp = new int[len][len];

		if(len == 1)
			return nums[0];
		
		for(int step = 0; step < len; step++) {
			for(int i = 0; i + step < len; i++) {
				
				int j = i + step;
				
				if(step == 0) {
					temp[i][j] = nums[i];
				}else if(step == 1) {
					temp[i][j] = nums[i] + nums[j];
				}else {
					temp[i][j] = temp[i][j - 1] + temp[j][j];
				}
				max = (max <= temp[i][j] ? temp[i][j] : max);
			}
		}
		
		return max;
	}
	
	/**
	 * @Description 动态规划法
	 * @param nums
	 * @return
	 */
	public static int maxSubArrayDynamicProgramming(int[] nums) {
		
		int prev = 0;//dp[i - 1]个的子序和
		int max = nums[0];
		
		for(int x : nums) {
			prev = Math.max(prev + x, x);
			max = Math.max(max, prev);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//		System.out.println(maxSubArray(nums));
		System.out.println(maxSubArrayDynamicProgramming(nums));
//		System.out.println(-2 < 1);
	}
}
