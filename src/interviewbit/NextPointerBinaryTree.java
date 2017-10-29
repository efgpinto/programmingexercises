package interviewbit;

public class NextPointerBinaryTree {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		try {
			TreeLinkNode father = root;
			TreeLinkNode current = root.left;
			current.next = root.right;
			
			TreeLinkNode next = current.left;
			while(next != null) {
				father = current;
				current = next;
				next = next.left;
				
				current.next = father.right;
				TreeLinkNode uncle = father.next;
				TreeLinkNode temp = father.right;
				while (uncle != null) {
					temp.next = uncle.left;
					uncle.left.next = uncle.right;
					temp = uncle.right;
					uncle = uncle.next;
				}
			}
		}
		catch(NullPointerException e) {
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
