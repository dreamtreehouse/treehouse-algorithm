package com.treehouse.algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.treehouse.algorithm.model.TreeNode;

/**
 * 	二叉树遍历 : 
 * 		前序遍历、中序遍历、后序遍历、层序遍历
 */
public class BinaryTreeTraversal {
	
	/**
	 * @Description 前序遍历
	 * @param root
	 * @throws
	 */
	public static void preorderTraversal(TreeNode root){
		
		if(root == null)
			return;
		
		if(root != null){
			//遍历根节点
			System.out.print(root.val + " ");
			//遍历左子树
			preorderTraversal(root.left);
			//遍历右子树
			preorderTraversal(root.right);
		}
	}
	
	/**
	 * @Description 中序遍历
	 * @param root
	 * @throws
	 */
	public static void inorderTraversal(TreeNode root){
		
		if(root == null)
			return;
		
		//遍历左子树
		if(root.left != null){
			inorderTraversal(root.left);
		}
		
		//遍历根节点
		System.out.print(root.val + " ");
		
		//遍历右子树
		if(root.right != null){
			inorderTraversal(root.right);
		}
	}
	
	/**
	 * @Description 后序遍历
	 * @param root
	 * @throws
	 */
	public static void postOrderTraversal(TreeNode root){
		
		if(root == null)
			return;
		
		//遍历左子树
		if(root.left != null){
			postOrderTraversal(root.left);
		}
		
		//遍历右子树
		if(root.right != null){
			postOrderTraversal(root.right);
		}
		
		//遍历根节点
		System.out.print(root.val + " ");
	}
	
	/**
	 * @Description 层序遍历
	 * @param root
	 * @throws
	 */
	public static void levelOrderTraversal(TreeNode root){
		
		if(root  == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			TreeNode head = queue.poll();
			System.out.print(head.val + " ");
			if(head.left != null){
				queue.add(head.left);
			}
			if(head.right != null){
				queue.add(head.right);
			}
		}
	}
	
	public static void main(String[] args){
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		//前序遍历
		System.out.print("前序遍历[ ");
		preorderTraversal(root);
		System.out.println("]");
		
		//中序遍历
		System.out.print("中序遍历[ ");
		inorderTraversal(root);
		System.out.println("]");
		
		//后序遍历
		System.out.print("后序遍历[ ");
		postOrderTraversal(root);
		System.out.println("]");
		
		//层序遍历
		System.out.print("层序遍历[ ");
		levelOrderTraversal(root);
		System.out.println("]");
		
	}
}
