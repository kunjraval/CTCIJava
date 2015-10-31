package ctci_chapter4;

public class Sol5_2 {

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
		
		System.out.println("Is Binary Tree Binary Search Tree? " + checkBST(btree.root, null, null));
	}

	public static boolean checkBST(TNode n, Integer min, Integer max) {
		if(n == null) return true;
		
		if((min != null && min >= n.data) || 
			(max != null && max < n.data)) {
			return false;
		}
		
		if(!checkBST(n.left, Integer.MIN_VALUE, n.data) ||
				!checkBST(n.right, n.data, Integer.MAX_VALUE)) {
			return false;
		}
		
		return true;
	}
}
