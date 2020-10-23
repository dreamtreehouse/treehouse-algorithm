package com.treehouse.algorithm.leetcode;

import com.treehouse.algorithm.model.ListNode;

/**
 * 	题目描述：
 * 	   将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
	
	/**
	 * @Description 迭代法
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoListsWithIteration(ListNode l1, ListNode l2) {
		
		ListNode head = null;
		ListNode tail = null;
		
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				if(head == null) {
					head = tail = l1;
				}else {
					tail.next = l1;
					tail = l1;
				}
				l1 = l1.next;
			}else {
				if(head == null) {
					head = tail = l2;
				}else {
					tail.next = l2;
					tail = l2;
				}
				l2 = l2.next;
			}
		}
		
		if(l1 != null) {
			if(head == null) {
				head = l1;
			}else {
				tail.next = l1;
			}
		}
		
		if(l2 != null) {
			if(head == null) {
				head = l2;
			}else {
				tail.next = l2;
			}
		}
		
		return head;
	}
	
	/**
	 * @Description 递归法
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoListsWithRecursion(ListNode l1, ListNode l2) {
		
		if(l1 == null) {
			return l2;
		}else if(l2 == null) {
			return l1;
		}else if(l1.val <= l2.val) {
			l1.next = mergeTwoListsWithRecursion(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoListsWithRecursion(l1, l2.next);
			return l2;
		}
	}
	
	public static void main(String[] args){
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
//		ListNode head = mergeTwoListsWithIteration(l1, l2);
		ListNode head = mergeTwoListsWithRecursion(l1, l2);
		while(head != null){
			System.out.print(head.val);
			if(head.next != null){
				System.out.print("->");
			}
			head = head.next;
		}
	}
}
