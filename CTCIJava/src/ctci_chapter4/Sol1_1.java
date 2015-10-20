package ctci_chapter4;

/*
 * check if the binary tree is balanced
 * 
 * solution 1
 */
public class Sol1_1 {

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
		if(node == null) {
			return true;
		}

		int heightDiff = getHeight(node.left) - getHeight(node.right);
		if(Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}
	
	public static int getHeight(TNode node) {
		if(node == null)
			return 0;
		
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
}