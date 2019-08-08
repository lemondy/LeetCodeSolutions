package cn.edu.bit.lemondy.leetcode.medium;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author zhang
    *        ����ö�������һ�������������߶ȣ��������ǵݹ�ķ�ʽ����ȣ���¼���Ĳ�������
 */
public class BinaryTreeMaxHeight {
	public static int binaryTreeMaxHeight(BinaryTreeNode node) {
		Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<>();
		if (node == null) {
			return 0;
		}
		int depth = 0;
		queue.add(node);
		BinaryTreeNode ptrNode;
		while (!queue.isEmpty()) {
			depth++;
			int curLevelSize = queue.size();
			int cnt = 0;
			while (cnt < curLevelSize) {
				ptrNode = queue.poll();
				cnt++;
				if (ptrNode.getLeftNode() != null) {
					queue.add(ptrNode.getLeftNode());
				}
				if (ptrNode.getRightNode() != null) {
					queue.add(ptrNode.getRightNode());
				}
				
			}
		}
		return depth;
	}
	
	public static void main(String[] args) {
		
	}
}

/**
 * @descrption �������ڵ�
 * @author zhang
 *
 */
class BinaryTreeNode {
	private int val;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	
	public int getVal() {
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
}