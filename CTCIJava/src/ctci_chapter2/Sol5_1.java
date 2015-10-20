package ctci_chapter2;

public class Sol5_1 {

	private static LinkedListImpl result = new LinkedListImpl();
	
	public static void main(String[] args) {
		LinkedListImpl firstList = new LinkedListImpl();
//		firstList.Add(7);
//		firstList.Add(1);
//		firstList.Add(6);
		
		firstList.Add(1);
		firstList.Add(2);
		firstList.Add(3);
		firstList.Add(4);
		
		LinkedListImpl secondList = new LinkedListImpl();
//		secondList.Add(5);
//		secondList.Add(9);
//		secondList.Add(2);
		
		secondList.Add(5);
		secondList.Add(6);
		secondList.Add(7);
		
		int initCarry = 0;
		Node n1 = firstList.head;
		Node n2 = secondList.head;
		
		System.out.print("first list: ");
		firstList.Traverse();
		
		System.out.print("\nsecond list: ");
		secondList.Traverse();
		
		System.out.print("\nresult list with added value: ");
		
		Node resNode = addLists(n1, n2, initCarry);
		while(resNode != null) {			
			System.out.print(resNode.data + "->");
			resNode = resNode.nextNode;
		}
	}

	public static Node addLists(Node l1, Node l2, int carry) {		
		
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		int val = carry;
		if(l1 != null) {
			val += l1.data;
		}
		if(l2 != null) {
			val += l2.data;
		}
		
		int tmpCarry = val/10;
		result.Add(val%10);
		
		if(l1 != null || l2 != null) {
			addLists(
						l1 == null ? null : l1.nextNode, 
						l2 == null ? null : l2.nextNode,
						tmpCarry
					);
		}
		
		return result.head;
	}
}