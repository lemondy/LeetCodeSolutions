package cn.edu.bit.lemondy.leetcode.easy;

import java.util.LinkedList;

/**
 * 
 * @author lemon
 * problem: 
 * 			给定一颗二叉树，判断该树是否是高度平衡的。高度平衡指的是对每个节点它的左右子树高度差不超过1.
 * solution： 
 * 			基于求树深度算法，遍历二叉树的节点，依次判断每个节点是否满足要求。
 * 
 */

public class BalanceTree {

	public class TreeNode {
		  int val;
		  TreeNode left;
		  TreeNode right;
		  TreeNode(int x) { val = x; }
		  public TreeNode() {
			// TODO Auto-generated constructor stub
		}
	}
		 
	
	public int treeHeight(TreeNode node){
	        int hl,hr,max;
	        if(node != null){
	            hl = treeHeight(node.left);
	            hr = treeHeight(node.right);
	            max = hl>hr?hl:hr;
	            return (max+1);
	        }else{
	            return 0;
	        }
	    }
	    
	    
	public boolean isBalanced(TreeNode root) {
	    	if(root == null)
	    		return true;
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  //先入先出队列
	        queue.addLast(root);
	        int hl=0,hr=0;
	        
	        while(!queue.isEmpty()){
	            TreeNode node = (TreeNode)queue.removeFirst();   //判断当前节点是否是高度平衡
	            hl = treeHeight(node.left);
	            hr = treeHeight(node.right);
	            if(Math.abs(hl-hr)>1)
	                return false;
	            if(node.left!=null){
	                queue.add(node.left);
	            }
	            if(node.right != null){
	                queue.add(node.right);
	            }
	                   
	        }
	        return true;
	        
	        
	    }
	    
	public static void main(String[] args) {
			
	}
}
