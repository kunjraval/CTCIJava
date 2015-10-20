package ctci_chapter4;

/*
 * check if the binary tree is balanced
 * 
 * solution 2
 */
public class Sol1_2 {

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
		
		System.out.println("is the tree balanced? " + isBalanced(btree.root));
	}

	public static boolean isBalanced(TNode node) {
		if(getHeight(node) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int getHeight(TNode root) {
		if(root == null) {
			return 0;
		}
		
		/* check if left tree is balanced */
		int leftHeight = getHeight(root.left);
		if(leftHeight == -1) {
			return -1; //not balanced
		}
		
		/* check if right tree is balanced */
		int rightHeight = getHeight(root.right);
		if(rightHeight == -1) {
			return -1; //not balanced
		}
		
		/* check if current node is balanced */
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) {
			return -1;
		}
		else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}