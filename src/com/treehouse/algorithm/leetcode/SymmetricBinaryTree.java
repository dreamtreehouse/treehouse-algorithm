package com.treehouse.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.treehouse.algorithm.model.TreeNode;

/**
 *	题目描述：给定一个二叉树，检查它是否是镜像对称的。
 */
public class SymmetricBinaryTree {
	
	public static boolean isSymmetric(TreeNode root){
//		return recursion(root, root);
		return iteration(root, root);
	}
	
	/**
	 * @Description 递归法
	 * @param p 左指针
	 * @param q 右指针
	 * @return
	 * @throws
	 */
	public static boolean recursion(TreeNode p, TreeNode q){
		
		if(p == null && q == null)
			return true;
		
		if(p == null || q == null)
			return false;
		
		
		return p.val == q.val && recursion(p.left, q.right) && recursion(p.right, q.left);
	}
	
	/**
	 * @Description 迭代法
	 * @param p 左指针
	 * @param q 右指针
	 * @return
	 * @throws
	 */
	public static boolean iteration(TreeNode p, TreeNode q){
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(p);
		queue.offer(q);
		
		while(!queue.isEmpty()){
			
			p = queue.poll();
			q = queue.poll();
			
			if(p == null && q == null)
				return true;
			
			if((p == null || q == null) || (p.val != q.val))
				return false;
			
			queue.offer(p.left);
			queue.offer(q.right);
			
			queue.offer(p.right);
			queue.offer(q.left);
			
		}
		
		return true;
	}
	
	public static void main(String[] args){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println(isSymmetric(root));
	}
}