package interviewbit;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergedKSortedLists {
	
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for (ListNode l : a) {
			
			ListNode next = l;
			while (next != null) {
				queue.add(next.val);
				next = next.next;
			}
			
	 	}
		
		System.out.println(queue);
		
		
		ListNode start = new ListNode(queue.poll());
		ListNode prev = start;
		while (!queue.isEmpty()) {
			ListNode recent = new ListNode(queue.poll());
			prev.next = recent;
			prev = recent;
		}
		
		return start;
	    
	}
	
	public static void main(String[] args) {

		ListNode n3l1 = new ListNode(3);
		ListNode n2l1 = new ListNode(2, n3l1);
		ListNode n1l1 = new ListNode(1, n2l1);
		
		ListNode n2l2 = new ListNode(4);
		ListNode n1l2 = new ListNode(3, n2l2);
		
		ListNode n3l3 = new ListNode(6);
		ListNode n2l3 = new ListNode(5, n3l3);
		ListNode n1l3 = new ListNode(4, n2l3);
		
		
		ArrayList<ListNode> l = new ArrayList<ListNode>();
		l.add(n1l1);
		l.add(n1l2);
		l.add(n1l3);
		
		MergedKSortedLists o = new MergedKSortedLists();
		ListNode n = o.mergeKLists(l);
		while(n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

}
