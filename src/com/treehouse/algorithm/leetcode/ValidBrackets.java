package com.treehouse.algorithm.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目描述:
 * 	     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *    有效字符串需满足：
 *    	左括号必须用相同类型的右括号闭合。
 *    	左括号必须以正确的顺序闭合。
 *    	注意空字符串可被认为是有效字符串。
 */
public class ValidBrackets {
	
	/**
	 * @Description 栈实现
	 * @param s
	 * @return
	 */
	public static Boolean isValidBrackets(String s) {
		
		int len = s.length();
		
		if(len % 2 != 0)
			return false;
		
		HashMap<Character, Character> dict = new HashMap<Character, Character>();
		dict.put(')', '(');
		dict.put('}', '{');
		dict.put(']', '[');
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if(dict.containsKey(ch)) {
				//栈顶必然是当前右括号匹配的左括号,否则不是有效的字符。
				if(stack.isEmpty() || !dict.get(ch).equals(stack.pop())) {
					return false;
				}
			}else{
				//将左括号放入栈
				stack.push(ch);
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isValidBrackets("))"));
	}
}
