package ctci_chapter4;

/*
 * find the next for for given 'n' node
 * 
 */
public class Sol6 {

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
		
		System.out.println("traversing through the list:");
		btree.traverse();
		System.out.println("next node for ");
	}

	public static TNode findNextNode(TNode n) {
		if(n == null) return null;
		
		if(n.right != null) {
			return leftMostChild(n.right);
		}
		else {
			TNode q = n;
			TNode x = q.parent;
			
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}		
	}
	
	public static TNode leftMostChild(TNode l) {
		if(l == null) return null;
		
		while(l.left != null) {
			l = l.left;
		}
		return l;
	}
}