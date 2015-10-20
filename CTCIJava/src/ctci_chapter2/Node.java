package ctci_chapter2;

/*
 * this is a base class for creating a node
 * 
 */
public class Node {
	int data;
	Node nextNode;
	
	public Node() {}
	
	public Node(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "" + data;
	}
}
