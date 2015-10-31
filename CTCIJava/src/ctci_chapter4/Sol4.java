package ctci_chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.
 * e.g. if you have D depths, you'll have D linked lists 
 * 
 */
public class Sol4 {

	public static void main(String[] args) {
		BinaryTreeImpl btree = new BinaryTreeImpl();
		btree.add(50);
		btree.add(25);
		btree.add(75);
		btree.add(10);
		btree.add(30);
		btree.add(35);
		btree.add(60);
		btree.add(65);
		btree.add(80);
		btree.add(85);
		btree.add(1);
		btree.add(18);
		btree.add(78);
		
		ArrayList<LinkedList<TNode>> linkedlistArr = new ArrayList<LinkedList<TNode>>();
		linkedlistArr = createEveryLevelLinkedList(btree.root);
		int lvl=1;
		
		for(LinkedList<TNode> s : linkedlistArr) {
			System.out.print("level- " + lvl + " ");
			System.out.println(s.toString());
			lvl++;
		}
		
	}
	
	public static ArrayList<LinkedList<TNode>> createEveryLevelLinkedList(TNode root) {
		ArrayList<LinkedList<TNode>> result = new ArrayList<LinkedList<TNode>>();
		LinkedList<TNode> current = new LinkedList<TNode>();
		
		if(root != null) {
			current.add(root);
		}
		
		while(current.size() > 0) {
			result.add(current);
			LinkedList<TNode> parents = current;
			current =  new LinkedList<TNode>();
			for(TNode parent : parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}			
		}
		
		return result;		
	}

}