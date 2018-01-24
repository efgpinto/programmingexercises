
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
	int val;
	public TreeNode left;
	public TreeNode right;

    TreeNode(int x) { val = x; } 
}

public class TreeSearches {
	
	public static void dfs(TreeNode root) {
		if (root == null)
			return;
		
		Stack<TreeNode> queue = new Stack<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode temp = queue.pop();
			System.out.println("Hello from: " + temp.val);
			if (temp.left != null)
				queue.push(temp.left);
			if (temp.right != null)
				queue.push(temp.right);
		}
	}
	
	public static void bfs(TreeNode root) {
		
		if (root == null)
			return;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.println("Hello from: " + temp.val);
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
		
	}
	
	
	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t7 = new TreeNode(7);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = t1;
		t2.right = t3;
		
		TreeNode t6 = new TreeNode(6);
		t6.left = t5;
		t6.right = t7;
		
		TreeNode t4 = new TreeNode(4);
		t4.left = t2;
		t4.right = t6;
		
		dfs(t4);
	}

}
