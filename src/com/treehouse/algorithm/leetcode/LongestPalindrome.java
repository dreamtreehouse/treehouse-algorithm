package com.treehouse.algorithm.leetcode;

/**
 * 题目描述:
 *    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {
	
	 public static String longestPalindrome(String s) {
		 
		 String max = "";
		 int len = s.length();
		 Boolean[][] temp = new Boolean[len][len];
		 
		 //循环增长步长:0~length-1
		 for(int step = 0; step < len; step++){
			 //遍历子串
			 for(int i = 0; i + step < len; i++){
				 int j = i + step;
				 //判断子串是否是回文串
				 if(step == 0){
					 //单个字符一定是回文
					 temp[i][j] = true;
				 }else if(step == 1){
					 //两个字符相等是回文
					 temp[i][j] = (s.charAt(i) == s.charAt(j));
				 }else{
					 //多个字符子串
					 if(s.charAt(i) == s.charAt(j) && temp[i + 1][j - 1]){
						 temp[i][j] = true;
					 }else{
						 temp[i][j] = false;
					 }
				 }
				 
				 if(temp[i][j] && max.length() < step + 1){
					 max = s.substring(i, j + 1);
				 }
			 }
		 } 
		 
		 return max;
	 }
	 
	 public static void main(String[] args){
		 System.out.println(longestPalindrome("abcdabcb"));
	 }
}
