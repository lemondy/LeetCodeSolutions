package cn.edu.bit.lemondy.leetcode.easy;

import java.util.LinkedList;

public class BalanceTree {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
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
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.addLast(root);
	        int hl=0,hr=0;
	        
	        while(!queue.isEmpty()){
	            TreeNode node = (TreeNode)queue.removeFirst();
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
