package ctci_chapter2;

import java.util.Stack;

/*
 * check if the linked list is a palindrome
 * solution 1
 * 
 */
public class Sol7 {

	public static void main(String[] args) {
		LinkedListImpl list = new LinkedListImpl();
		list.Add(1);
		list.Add(2);
		list.Add(3);
		list.Add(4);
		list.Add(5);
		list.Add(4);
		list.Add(3);
		list.Add(2);
		list.Add(1);
		
		Node node = list.head;
		
		System.out.println("actual list: ");
		list.Traverse();
	
		System.out.println("\nis the list a palindrome? " + checkPalindrome(node));
	}

	public static boolean checkPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.nextNode != null) {
			stack.push(slow.data);
			
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
				
		if(fast != null) { // this will run if list is odd
			slow = slow.nextNode;
		}
		
		while(slow != null) {
			int topVal = stack.pop().intValue();
			if(topVal != slow.data) {
				return false;
			}
			slow = slow.nextNode;
		}
		
		return true;
	}
}