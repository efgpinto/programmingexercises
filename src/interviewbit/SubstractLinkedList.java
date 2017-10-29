package interviewbit;

public class SubstractLinkedList {
	
	public ListNode subtract(ListNode a) {
			    
	    int count = 1;
	    ListNode next = a.next;
	    while (next != null) {
	        System.out.println(next.val + " val "+next);
	        count++;
	        next = next.next;
	    }
	   
	    //System.out.println("COUNT:" + count);
	    
	    next = a;
	    for (int i = 0; i < count/2; i++) {

		    ListNode nextFast = next;
	        System.out.println(nextFast.val);
	        for (int j = 0; j < count-1-i*2; j++) {
	            nextFast = nextFast.next;
	        }
	        
	        next.val = nextFast.val-next.val;
	        next = next.next;
	        //System.out.println("Novo valor: " + next.val + "next: " + next.next.val);
	        
	    }
	    
	    return a;
	}
	
	public static void main(String[] args) {
		SubstractLinkedList s = new SubstractLinkedList();
		
		ListNode e5 = new ListNode(5);
		ListNode e4 = new ListNode(4,e5);
		ListNode e3 = new ListNode(3,e4);
		ListNode e2 = new ListNode(2,e3);
		ListNode e1 = new ListNode(1,e2);
		
		s.subtract(e1);
		System.out.println("\nRESULTS");
		ListNode l = e1;
		while (l != null) {
			System.out.println(l.val);
			l=l.next;
		}
	}

}
