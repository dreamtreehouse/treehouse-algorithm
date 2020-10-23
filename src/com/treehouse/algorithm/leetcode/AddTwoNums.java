package com.treehouse.algorithm.leetcode;

import com.treehouse.algorithm.model.ListNode;

/**
 * 题目描述:
 *    给出两个"非空"的链表用来表示两个非负的整数。其中，它们各自的位数是按照"逆序"的方式存储的，并且它们的每个节点只能存储"一位"数字。
 *    如果我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *    假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoNums {
	
	public static ListNode addTwoNums(ListNode l1, ListNode l2){
		
		ListNode head = null, tail = null;
		int carry = 0;//进位值
		
		while(l1 != null || l2 != null){
			
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			
			int sum = n1 + n2 + carry;
			
			if(head == null){
				head = tail = new ListNode(sum % 10);
			}else{
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			
			carry = sum / 10;
			
			if(l1 != null){
				l1 = l1.next;
			}
			
			if(l2 != null){
				l2 = l2.next;
			}
		}
		
		
		if(carry > 0){
			tail.next = new ListNode(carry);
		}
		
		return head;
	}
	
	public static void main(String[] args){
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(1);
		
		ListNode head = addTwoNums(l1, l2);
		while(head != null){
			System.out.print(head.val);
			if(head.next != null){
				System.out.print("->");
			}
			head = head.next;
		}
	}
}
