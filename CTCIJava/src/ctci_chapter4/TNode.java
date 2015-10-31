package ctci_chapter4;

/*
 * this is a base class for creating a tree
 * 
 */
public class TNode {
	int data;
	TNode left;
	TNode right;
	TNode parent;
	
	TNode(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "" + data;
	}
}
