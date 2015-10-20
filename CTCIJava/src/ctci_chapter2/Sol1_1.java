package ctci_chapter2;

import java.util.HashSet;

/*
 * write code to remove duplicates from unsorted linked list
 * solution 1
 * 
 */
public class Sol1_1 {

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
		
		HashSet<Integer> set = new HashSet<Integer>();
		Node prev = null;
		Node current = obj.head;
		
		while(current != null) {
			if(set.contains(current.data)) {
				prev.nextNode = current.nextNode;
			}
			else {
				set.add(current.data);
				prev = current;
			}
			current = current.nextNode;			
		}
		
		System.out.println("\n\nlinked list after removing duplicates: ");
		obj.Traverse();
	}

}