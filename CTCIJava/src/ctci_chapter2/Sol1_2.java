package ctci_chapter2;

/*
 * write code to remove duplicates from unsorted linked list
 * solution 2
 * 
 */
public class Sol1_2 {

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
		obj.Add(2);
		
		System.out.println("original linked list with duplicates: ");
		obj.Traverse();

		Node current = obj.head;
		
		while(current != null) {			
			Node runner = current;
			
			while(runner.nextNode != null) {
				if(runner.nextNode.data == current.data) {
					runner.nextNode = runner.nextNode.nextNode;
				}
				else {
					runner = runner.nextNode;
				}
			}
			current = current.nextNode;
		}
		
		System.out.println("\n\nlinked list after removing duplicates: ");
		obj.Traverse();
	}
}
