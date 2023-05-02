//Question: Write a program to check if a Binary Tree is Binary Search Tree(NO DUPLICATES)
//
//class node{
//	int data;
//	node left, right;
//}

public class CheckIfBinaryTreeIsBST {
	
	// For a BT to be BST, the following conditions should be met:
	// if its a left node, node's max value should be less than root'value
	// if its a right noded, node's min value should be greater than root's value
	
	public static void main()
	{
		//Call the function from here
		//checkBST(root, INTEGER_MAXVALUE, INTEGER_MINVALUE);
	}
	public boolean checkBST(node root, int min, int max) {
		
		node currNode = root;
		//base condition
		if(currNode == null) {
			return true;
		}
		
		if(currNode.data < min || currNode.data > max) {
			return false;
		}
//		if(currNode.left != null) {
//			if(checkBST(currNode.left, min, currNode.data) == false) {
//				return false;
//			}
//		}
//		if(currNode.right != null) {
//			if(checkBST(currNode.right, currNode.data, max) == false) {
//				return false;
//			}
//		}
		
		
		
		return checkBST(currNode.left, currNode.data - 1, max) &&
					checkBST(currNode.right, min, currNode.data + 1);
	}
	
}