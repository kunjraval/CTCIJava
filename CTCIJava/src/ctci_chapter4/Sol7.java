package ctci_chapter4;

/*
 * write a program to find the first common ancestor of two nodes in binary tree
 * 
 */
public class Sol7 {

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
		
		int d1=1;
		int d2=35;
		TNode p = new TNode(d1);
		TNode q = new TNode(d2);
		
		System.out.println("first common ancestor for nodes- " + p.toString() + " & " + q.toString() + " is- " 
				+ commonAncestor(btree.root, btree.find(d1), btree.find(d2)));
	}
	
	public static boolean chkDescendent(TNode root, TNode n) {
		
		if(root == null) { return false; }
		if(root == n) { 
			return true; }
		
		return chkDescendent(root.left, n) || chkDescendent(root.right, n);
	}

	public static TNode commonAncestor(TNode root, TNode n1, TNode n2) {
		if(!chkDescendent(root, n1) || !chkDescendent(root, n2)) { //ERROR CHECK
			return null;
		}		
		return commonAncestorHelper(root,n1,n2);
	}
	
	public static TNode commonAncestorHelper(TNode root, TNode p, TNode q) {
		if(root == null) return null;
		if(root == p) return p;
		if(root == q) return q;
		
		boolean is_p_on_left = chkDescendent(root.left, p);
		boolean is_q_on_left = chkDescendent(root.left, q);
		
		if(is_p_on_left != is_q_on_left) {
			return root;
		}
		
		TNode child_side = is_p_on_left ? root.left : root.right;
		
		return commonAncestorHelper(child_side, p, q);
	}
}
