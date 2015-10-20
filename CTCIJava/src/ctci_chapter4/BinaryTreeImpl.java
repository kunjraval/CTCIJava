package ctci_chapter4;

public class BinaryTreeImpl {

	//TNode -> Key (data)
	//     -> 2 children (left child, right child)
	TNode root;
	
	public void add(int data) {
		TNode node = new TNode(data);
		
		if(root == null)
			root = node;
		
		//if data < root, traverse left child, else traverse right child
		//until we get a node that we can't traverse... insert our new node
		traverseAndAddTNode(root, node);
	}
	
	/**
	 * This is a recursive class to add a node to binary tree
	 * @param node
	 * @param nodeToAdd
	 */
	public void traverseAndAddTNode(TNode node, TNode nodeToAdd) {
		
		if(nodeToAdd.data < node.data) 
		{
			if(node.left == null) 
			{
				nodeToAdd.parent = node;
				node.left = nodeToAdd;
			} 
			else 
			{
				traverseAndAddTNode(node.left, nodeToAdd);
			}
		}
		else 
		{
			if(nodeToAdd.data > node.data) 
			{
				if(node.right == null) 
				{
					nodeToAdd.parent = node;
					node.right = nodeToAdd;
				} 
				else 
				{
					traverseAndAddTNode(node.right, nodeToAdd);
				}
			}
		}
	}
	
	public void traverse() {
		
		if(root != null) 
		{
			TNode nodeToTraverse = root;
			
			if(nodeToTraverse.left == null && nodeToTraverse.right == null) {
				System.out.println(root.data);
			}
			else{
				System.out.println("~~~ In-order traversal ~~~");
				inOrderTraversal(nodeToTraverse);
				
				System.out.println("~~~ Pre-order traversal ~~~");
				preOrderTraversal(nodeToTraverse);
				
				System.out.println("~~~ Post-order traversal ~~~");
				postOrderTraversal(nodeToTraverse);
			}	
		}
	}
	
	/**
	 * In-order traversal
	 * left -> root -> right
	 * 
	 * @param node
	 */
	public void inOrderTraversal(TNode node) {
		if(node.left != null) {
			inOrderTraversal(node.left);
		}
		
		System.out.println(node.data);
		
		if(node.right != null) {
			inOrderTraversal(node.right);
		}
	}
	
	/**
	 * Pre-order traversal
	 * root -> left -> right
	 * 
	 * @param node
	 */
	public void preOrderTraversal(TNode node) {
		
		System.out.println(node.data);
		
		if(node.left != null) {
			preOrderTraversal(node.left);
		}
		
		if(node.right != null) {
			preOrderTraversal(node.right);
		}
	}
	
	/**
	 * Post-order traversal
	 * left -> right -> root
	 * 
	 * @param node
	 */
	public void postOrderTraversal(TNode node) {
		
		if(node.left != null) {
			postOrderTraversal(node.left);
		}
		
		if(node.right != null) {
			postOrderTraversal(node.right);
		}
		
		System.out.println(node.data);
	}
	
	public boolean delete(int val) {
		//case 1 node has no children
		//case 2 node has one child
		//case 3 node has two children
		
		TNode nodeToBeDeleted = find(val);
		
		if(nodeToBeDeleted != null) {
			
			if(nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) 
			{
				deleteCase1(nodeToBeDeleted);
			}
			else if(nodeToBeDeleted.left != null && nodeToBeDeleted.right != null) 
			{
				//case 3
				deleteCase3(nodeToBeDeleted);
			}
			else if(nodeToBeDeleted.left != null) 
			{
				//case 2 where the left child should be deleted
				deleteCase2(nodeToBeDeleted);
			}
			else if(nodeToBeDeleted.right != null) 
			{
				//case 2 where the right child should be deleted
				deleteCase2(nodeToBeDeleted);
			}
		}
		return false;
	}

	private void deleteCase1(TNode nodeToBeDeleted) 
	{	
		//check to see if node to be deleted is the left or the right child of the PARENT node
		if(nodeToBeDeleted.parent.left == nodeToBeDeleted) {
			nodeToBeDeleted.parent.left = null;
		}
		else if(nodeToBeDeleted.parent.right == nodeToBeDeleted) {
			nodeToBeDeleted.parent.right = null;
		}
	}
	
	private void deleteCase2(TNode nodeToBeDeleted) 
	{
		if(nodeToBeDeleted.parent.left == nodeToBeDeleted) 
		{
			if(nodeToBeDeleted.left != null) 
			{
				nodeToBeDeleted.parent.left = nodeToBeDeleted.left;
			}
			else if(nodeToBeDeleted.right != null) 
			{
				nodeToBeDeleted.parent.left = nodeToBeDeleted.right;
			}
		}
		else if(nodeToBeDeleted.parent.right == nodeToBeDeleted) 
		{
			if(nodeToBeDeleted.left != null) 
			{
				nodeToBeDeleted.parent.right = nodeToBeDeleted.left;
			}
			else if(nodeToBeDeleted.right != null) 
			{
				nodeToBeDeleted.parent.right = nodeToBeDeleted.right;
			}
		}
	}
	
	private TNode deleteCase3(TNode nodeToBeDeleted) {
		
		TNode minTNode = minTNodeTraversal(nodeToBeDeleted.right);
		
		deleteCase2(minTNode);
		
		minTNode.parent = nodeToBeDeleted.parent;
		minTNode.left = nodeToBeDeleted.left;
		minTNode.right = nodeToBeDeleted.right;
		
		if(nodeToBeDeleted.parent == null) 
		{
			root = minTNode;
		} 
		else 
		{
			if(nodeToBeDeleted.parent.left == nodeToBeDeleted) 
			{
				nodeToBeDeleted.parent.left = minTNode;
			} 
			else if(nodeToBeDeleted.parent.right == nodeToBeDeleted) 
			{
				nodeToBeDeleted.parent.right = minTNode;
			}
		}
		
		
		return null;
	}
	
	private TNode minTNodeTraversal(TNode node) {
		if(node.left == null) {
			return node;
		}
		return minTNodeTraversal(node.left);
	}

	public TNode find(int val) {
		
		if(root != null)
			return findTNode(root, new TNode(val));
		
		return null;
	}
	
	public TNode findTNode(TNode search, TNode node) {
		if(search == null)
			return null;
		
		if(search.data == node.data) {
			return search;
		} 
		else 
		{
			TNode returnTNode = findTNode(search.left, node);

			if(returnTNode == null) {
				returnTNode = findTNode(search.right, node);
			}
			
			return returnTNode;
		}
	}
}