package ctci_chapter2;

public class Sol6 {

	public static void main(String[] args) {
		LinkedListImpl list = new LinkedListImpl();
		list.Add(1);
		list.Add(2);
		list.Add(3);
		list.Add(4);
		list.Add(5);
		list.Add(6);
		list.Add(7);
		
		Node node = list.head;
		
		System.out.println("actual list: ");
		list.Traverse();
		
		System.out.println("\nis the list circular? " + checkCircularlist(node));		
	}

	public static boolean checkCircularlist(Node n) {
		Node slow = n;
		Node fast = n;
		
		while(fast != null && fast.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}
}
