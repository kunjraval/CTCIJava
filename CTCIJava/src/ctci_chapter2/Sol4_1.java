package ctci_chapter2;

/*
 * write a code to partition around value x, such that all the nodes less than x come before
 * all nodes greater than or equal to x
 * 
 * solution 1
 * 
 */
public class Sol4_1 {

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
		linekdListPartition(node, partitionVal);
		obj.Traverse();
	}

	public static void linekdListPartition(Node node, int val) {
		Node beforeHead = null;
		Node beforeTail = null;
		Node afterHead = null;
		Node afterTail = null;
		
		while(node != null) {
			Node next = node.nextNode;
			node.nextNode = null;
			
			if(node.data < val) {
				if(beforeHead == null) {
					beforeHead = node;
					beforeTail = beforeHead;
					
				} else {
					beforeTail.nextNode = node;
					beforeTail = node;
				}
			}
			else if(node.data >= val) {
				if(afterHead == null) {
					afterHead = node;
					afterTail = afterHead;
					
				} else {
					afterTail.nextNode = node;
					afterTail = node;
				}
			}
			
			node = next;			
		}
		
		if(afterHead != null) {
			beforeTail.nextNode = afterHead;
		}
	}
}
