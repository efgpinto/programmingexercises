package interviewbit;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

    TreeNode(int x) { val = x; } 
}

public class UniqueBinarySearchTrees {

	public ArrayList<TreeNode> generateTrees(int a) {
		ArrayList<TreeNode> bst = new ArrayList<TreeNode>();
		
		for (int i = 1; i <= a; i++) {
			TreeNode r = new TreeNode(i);
			bst.addAll(generateTrees(a, r));
		}
		
		return bst;
	}
	
	private ArrayList<TreeNode> generateTrees(int a, TreeNode root) {
		ArrayList<TreeNode> bst = new ArrayList<TreeNode>();
		
		// TODO para acabar ainda
		
		
		return bst;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
