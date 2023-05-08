//class node{
	//int data;
	//Node left;
	//Node right;
	//Node(int data){
	//  this.data = data;
	//  left=null;
	//  right=null;
	//}
	//}  

public class LargestBSTInBinaryTree {
    private static int ans = 1;
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here 
        return findLargestBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
    }
    public static int findLargestBST(Node root, int max, int min) {
		
		if(root == null) {
			return 0;
		}
		
		
		int leftSize = findLargestBST(root.left, root.data, min);
		int rightSize = findLargestBST(root.right, max, root.data);
		
		if(root.data < min || root.data > max) {
			return -1;
		}
		
		if(leftSize != -1 || rightSize != -1) {
			return -1;
		}

		return Math.max(leftSize + rightSize + 1, ans);
	}
    
}