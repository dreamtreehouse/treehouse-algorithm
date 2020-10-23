package com.treehouse.algorithm.model;

/**
 * 自定义链表节点
 */
public class ListNode {
	
	/**
	 * 节点值
	 */
	public int val;
	
	/**
	 * 节点指针
	 */
	public ListNode next;
	
	public ListNode() {}
	
	public ListNode(int val){
		this.val = val;
	}
	
	public ListNode(int val, ListNode node){
		this.val = val;
		this.next = node;
	}
}
