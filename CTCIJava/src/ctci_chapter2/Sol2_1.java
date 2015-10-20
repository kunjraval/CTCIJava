package ctci_chapter2;

/*
 * write an algorithm to find k-th to last element of a singly linked list 
 * solution 1
 * 
 */
public class Sol2_1 {

	static int i = 0;
	
	public static void main(String[] args) {
		LinkedListImpl obj = new LinkedListImpl();
		obj.Add(12);
		obj.Add(62);
		obj.Add(62);
		obj.Add(120);
		obj.Add(2);
		obj.Add(2);
		obj.Add(36);
		obj.Add(612);
		obj.Add(54);
		obj.Add(90);
		obj.Add(2);
		obj.Add(200);
		
		Node head = obj.head;
		int k=3;
		
		System.out.println("print the list: ");
		obj.Traverse();
		
		if(k == 0) {
			System.out.println("\n\n" + k + "-th to last element is: " 
					+ obj.tail.data);
		} else 
			System.out.println("\n\n" + k + "-th to last element is: " 
				+ findKthtoLastElement(head, k, i).data);				
	}

	public static Node findKthtoLastElement(Node head, int kth, int ith) {
		if(head == null) {
			return null;
		}

		Node node = findKthtoLastElement(head.nextNode, kth, ith);
		i += ith + 1;

		if(i == kth) {
			return head;
		}
		return node;
	}
}