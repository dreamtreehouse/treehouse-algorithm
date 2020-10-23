package com.treehouse.algorithm.leetcode;

/**
 * 题目描述:
 *    给定两个大小为m和n的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *    进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class FindMedianSortedArrays {
	
	/**
	 * @Description 归并法(2-路归并)
	 * @param nums1
	 * @param nums2
	 * @return
	 * @throws
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int l1 = nums1.length;
		int l2 = nums2.length;
		
		int[] nums = new int[l1 + l2];
		
		int i = 0, j = 0, k = 0;
		
		//将两个数组合并为一个新的正序数组
		while(i < l1 && j < l2){
			if(nums1[i] <= nums2[j]){
				nums[k++] = nums1[i];
				i++;
			}else{
				nums[k++] = nums2[j];
				j++;
			}
		}
		
		while(i < l1){
			nums[k++] = nums1[i++];
		}
		
		while(j < l2){
			nums[k++] = nums2[j++];
		}
		
		//对新的正序数组求中位数
		int len = nums.length;
		if(len % 2 == 0){
			//偶数
			return (nums[len / 2] + nums[len / 2 -1]) / 2.0;
		}else{
			//奇数
			return nums[(len - 1) / 2];
		}
    }
	
	public static void main(String[] args){
		
		int[] nums1 = new int[]{2};
		int[] nums2 = new int[]{};
		System.out.println(findMedianSortedArrays(nums1, nums2));

//		遍历新生成的正序数组		
//		System.out.print("[");
//		for(int x = 0; x < nums.length; x++){
//			if(x == (nums.length - 1)){
//				System.out.print(nums[x]);
//			}else{
//				System.out.print(nums[x] + ",");
//			}
//		}
//		System.out.print("]");
	}
}
