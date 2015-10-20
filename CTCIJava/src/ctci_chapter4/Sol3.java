package ctci_chapter4;

/*
 * given a sorted array with increasing order elements, create a BST with minimal height
 * 
 */
public class Sol3 {

	public static BinaryTreeImpl btree = new BinaryTreeImpl();
	
	public static void main(String[] args) {
		//int[] tree_array = {2,5,8,10,20,25,33,45,51};
		int[] tree_array = {1,5,8,10,12,15,18,20,22,25,28,30,33,35,40};
		
		createMinimalBST(tree_array, 0, tree_array.length-1);
		btree.inOrderTraversal(btree.root);
	}

	public static void createMinimalBST(int arr[], int start, int last) {
		if(last >= start) {
			int mid = (start + last) / 2;
			btree.add(arr[mid]);
			createMinimalBST(arr, start, mid-1);
			createMinimalBST(arr, mid+1, last);
		}
	}	
}