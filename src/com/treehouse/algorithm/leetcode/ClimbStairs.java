package com.treehouse.algorithm.leetcode;

/**
 * 	题目描述：
 * 		假设你正在爬楼梯。需要n阶你才能达到楼顶。
 * 		每次你可以爬1或2个台阶。
 * 		你有多少种不同的方法可以爬到楼顶呢
 * 	示例：
 * 		输入：3
 * 		输出：3
 * 		解释：有三种方法爬到楼顶
 * 			1阶 + 1阶 + 1阶
 * 			2阶 + 1阶
 * 			1阶 + 2阶
 * 	题解：
 *
 */
public class ClimbStairs {
	
	/**
	 * @Description 递归法(会超时)
	 * @param n
	 * @return
	 */
	public static int climbStairsRecursion(int n) {
		
		if(n == 1)
			return 1;
		
		if(n == 2)
			return 2;
		
		return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
	}
	
	/**
	 * @Description 动态规划
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		
		if(n == 1)
			return 1;
		
		if(n == 2)
			return 2;
		
		int f1 = 1, f2 = 2;
		
		int res = 0;
		for(int i = 3; i <= n; i++) {
			res = f1 + f2;
			f1 = f2;
			f2 = res;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(climbStairs(100));
	}
}
