package cn.edu.bit.lemondy.leetcode.medium;

public class OddEvenList {
	public static ListNode oddEvenList(ListNode head) {
        ListNode p = head;
        ListNode q = p;
        
        ListNode evenNode = new ListNode(0);
        ListNode evenHead = evenNode;
        int count = 1;
        while(p!=null){
            if(count%2==0){
                evenNode.next=p;
                q.next = p.next;
                evenNode=evenNode.next;
                //evenNode.next=null;
                if(q.next!=null)
                    q=q.next;
            }
            count++;
            p=p.next;
        }
        evenNode = null;
        q.next=evenHead.next;
        return head;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode head = oddEvenList(l1);
		while(head!=null){
			System.out.println(head);
			head = head.next;
		}
		
	}
}


// //Definition for singly-linked list.
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
// }

