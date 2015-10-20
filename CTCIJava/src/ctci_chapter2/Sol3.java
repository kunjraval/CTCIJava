package ctci_chapter2;

/*
 * write an algorithm to delete a node in the middle from singly linked list
 * 
 */
public class Sol3 {

	public static void main(String[] args) {
		LinkedListImpl obj = new LinkedListImpl();
		obj.Add(12);
		obj.Add(62);
		obj.Add(120);
		obj.Add(2);
		obj.Add(36);
		obj.Add(612);
		obj.Add(54);
		obj.Add(90);
		obj.Add(200);

		Node deleteNode = obj.get(5); //5 is a rank that needs to be deleted
		System.out.println("original linked list before deleting a node: ");
		obj.Traverse();
		
		System.out.println("\n\nnode removed? " + deleteNode(deleteNode));		
		obj.Traverse();
	}

	public static boolean deleteNode(Node nodeToDelete) {
		if(nodeToDelete == null || nodeToDelete.nextNode == null) {
			return false;
		}
		Node curr = nodeToDelete.nextNode;
		nodeToDelete.data = curr.data;
		nodeToDelete.nextNode = curr.nextNode;		
		return true; 
	}
}
