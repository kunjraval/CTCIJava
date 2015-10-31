package ctci_chapter4;

/*
 * check if the binary tree is binary search tree
 * 
 * solution 1
 */
public class Sol5_1 {

	public static Integer last_printed = null;
	
	public static void main(String[] args) {
		BinaryTreeImpl btree = new BinaryTreeImpl();
		btree.add(50);
		btree.add(25);
		btree.add(75);
		btree.add(10);
		btree.add(30);
		btree.add(35);
		btree.add(60);
		btree.add(65);
		btree.add(80);
		btree.add(85);
		btree.add(1);
		btree.add(18);
		btree.add(78);
		
		System.out.println("Is Binary Tree Binary Search Tree? " + checkBST(btree.root));
	}
	
	public static boolean checkBST(TNode root) {
		if(root == null) {
			return true;
		}
		
		if(!checkBST(root.left)) { //check left
			return false;
		}
		
		if(last_printed != null && root.data <= last_printed) { //check current
			return false;
		}
		
		if(!checkBST(root.right)) { //check right
			return false;
		}
		
		return true;
	}
}