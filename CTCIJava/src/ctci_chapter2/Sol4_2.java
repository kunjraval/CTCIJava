package ctci_chapter2;

/*
 * write a code to partition around value x, such that all the nodes less than x come before
 * all nodes greater than or equal to x
 * 
 * solution 2
 * 
 */
public class Sol4_2 {

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
		
		Node node = obj.head;
		int partitionVal = 100;
		
		System.out.println("original linked list before partitioning: ");
		obj.Traverse();
		
		System.out.println("\n\nlinked list after partitioning: ");		
		obj.head = linekdListPartition(node, partitionVal);
		obj.Traverse();
	}

	public static Node linekdListPartition(Node node, int val) {
		Node head = node;
		Node tail = node;
		
		while(node != null) {
			Node next = node.nextNode;			
			if(node.data < val) {
				node.nextNode = head;
				head = node;
			}
			else {
				tail.nextNode = node;
				tail = node;
			}			
			node = next;			
		}
		
		tail.nextNode = null;
		return head;
	}
}
