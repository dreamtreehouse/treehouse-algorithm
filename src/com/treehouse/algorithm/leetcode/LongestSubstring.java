package com.treehouse.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目描述：
 * 	     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 	     请注意，你的答案必须是 子串 的长度，而不是子序列。
 */
public class LongestSubstring {
	
	/**
	 * @Description 方法一:HashSet
	 * @param s
	 * @return
	 * @throws
	 */
	public static int lengthOfLongestSubstring(String s){
		
		HashSet<Character> hset = new HashSet<Character>();
		
		int max = 0;
		int tail = 0;
		int n = s.length();
		
		for(int i = 0; i < n; i++){
			
			if(i != 0){
				hset.remove(s.charAt(i - 1));
			}
			
			while(tail < n && !hset.contains(s.charAt(tail))){
				//右指针不停右移
				hset.add(s.charAt(tail));
				tail++;
			}
			max = Math.max(max, tail - i);
		}
		
		return max;
	}
	
	/**
	 * @Description 方法二:HashMap
	 * @param s
	 * @return
	 * @throws
	 */
	public static int lengthOfLongestSubstring2(String s){
		
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		int max = 0;
		int left = 0; //左指针
		
		for(int i = 0; i < s.length(); i++){
			
			if(hmap.containsKey(s.charAt(i))){
				//左指针右移
				left = Math.max(left, hmap.get(s.charAt(i)) + 1);
			}
			
			hmap.put(s.charAt(i), i);
			max = Math.max(max, i - left + 1);
		}
		
		return max;
	}
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		System.out.println("执行结果:" + lengthOfLongestSubstring2("abcabcbb"));
		long end = System.currentTimeMillis();
		System.out.println("执行时间:" + (end - start) + "毫秒");
	}
}
