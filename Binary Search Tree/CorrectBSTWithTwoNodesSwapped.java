
// Question: Given an in-correct BST, Correct it using two swaps.
// It is known that all nodes are unique and only 2 swaps are required to correct the tree


//node Class 
//private class node {
//int data;
//node left;
//node right;
//	node(int data){
//		this.data = data;
//	}	
//}

public class CorrectBSTWithTwoNodesSwapped {
	
	private node first, prev, middle, last;
	
	public  void correctBST(node root) {
		
		///Base Condition
		if(root == null) {
			return;
		}
		
		//go left
		correctBST(root.left);
		
		//Main Logic
		if(prev != null && root.data < prev.data) {
			if(first == null) {
				first = prev;
				middle = root;
			}
			else {
				last = root;
			}
		}
		prev = root;
		correctBST(root.right);
		
	}
	
	public void getResult(node root) {
		first = prev = middle = last = null;
		prev = new node(Integer.MIN_VALUE);
		correctBST(root);
		if(last == null) {
			middle = last;
		}
		//swap(first, last) to correct the tree
	}
}
