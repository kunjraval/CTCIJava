package ctci_chapter2;

/*
 * write an algorithm to find k-th to last element of a singly linked list 
 * solution 2
 * 
 */
public class Sol2_2 {

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
		
		int k=3;
		Node head = obj.head;
		
		System.out.println("print the list: ");
		obj.Traverse();
		
		if(k == 0) {
			System.out.println("\n\n" + k + "-th to last element is: " 
					+ obj.tail.data);
		} else 
			System.out.println("\n\n" + k + "-th to last element is: " 
				+ findKthtoLastElement(head, k).data);
	}
	
	public static Node findKthtoLastElement(Node head, int k) {
		if(head == null) {
			return null;
		}
		
		Node p1 = head;
		Node p2 = head;
		
		for(int i=0; i<k-1; i++) {
			if(p2 == null)
				return null;
			p2 = p2.nextNode;
		}
		
		if(p2 == null) return null;
		
		while(p2.nextNode != null) {
			p1 = p1.nextNode;
			p2 = p2.nextNode;
		}
		
		return p1;
	}
}