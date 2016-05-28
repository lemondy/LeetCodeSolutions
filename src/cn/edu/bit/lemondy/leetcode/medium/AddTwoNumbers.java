package cn.edu.bit.lemondy.leetcode.medium;

/**
 * 
 * @author lemon
 * problem: 
 * 			两个用链表表示的非负整数，该整数是一反序表示的。如： 2->4->3  5->6->4 他们的和为 7->0->8。
 * solution：
 * 			手动模拟加法器。依次遍历每个链表，求和，记录进位情况。
 */

public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode head = null;
		ListNode node1 = l1.next;
		ListNode node2 = l2.next;
		ListNode curNode;
		int sum = 0;
		int jinwei = 0;
		
		sum = l1.val + l2.val;
		if(sum >= 10){
			sum = sum - 10;
			jinwei = 1;
		}else{
			jinwei = 0;
		}
		head =new ListNode(sum);	
		curNode = head;
		
		while(node1!=null && node2!=null){ //循环次数为两者中较短的长度
			
			sum = node1.val+ node2.val + jinwei;
			if(sum>=10){
				sum = sum -10;
				jinwei = 1;
			}else{
				jinwei = 0;
			}

			curNode.next = new ListNode(sum);
			curNode = curNode.next;
			node1 = node1.next;
			node2 = node2.next;
		}
		
		while(node1!=null){
			sum = node1.val + jinwei;
			if(sum>=10){
				sum = sum -10;
				jinwei = 1;
			}else{
				jinwei = 0;
			}
			curNode.next = new ListNode(sum);
			curNode = curNode.next;
			node1 = node1.next;
		}
		
		while(node2!=null){
			sum = node2.val + jinwei;
			if(sum>=10){
				sum = sum -10;
				jinwei = 1;
			}else{
				jinwei = 0;
			}
			curNode.next = new ListNode(sum);
			curNode = curNode.next;
			node2 = node2.next;
		}
		if(jinwei!=0){
			curNode.next = new ListNode(1);
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		//l1.next = new ListNode(4);
		//l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		//l2.next = new ListNode(6);
		//l2.next.next = new ListNode(4);
		//System.out.println(addTwoNumbers(l1, l2));
		ListNode resultListNode = addTwoNumbers(l1, l2);
		while(resultListNode!=null){
			System.out.println(resultListNode.val);
			resultListNode = resultListNode.next;
		}
	}
}

