package ctci_chapter2;

public class LinkedListImpl {

	int size = 0;
	Node head;
	Node tail;
	
	public void Add(int data) {
		/*
		 * test cases
		 * 1- list is empty
		 * 2- list is not empty
		 */
		Node node = new Node(data);
		
		if(tail == null) {
			head = node;
			tail = node;
		}
		else {
			tail.nextNode = node;
			tail = node;
		}
		size++;
	}
	
	public void Traverse() {
		/*
		 * test cases
		 * 1- list is empty
		 * 2- list is not empty
		 */
		
		if(head != null) {
			Node node = head;
			System.out.print(node + "->");
			
			while(node.nextNode != null) {
				node = node.nextNode;
				System.out.print(node + "->");
			}
			
		} else {
			System.out.println("Linked List is null right now.");
		}
	}
	
	public Node get(int i) {
		int start = 1;
		Node returnNode = head;
		
		while(returnNode != null) {
			if(start == i) {
				return returnNode;
			}
			returnNode = returnNode.nextNode;
			start++;
		}
		
		return null;
	}
}
