

//class node{
//	int data;
//	node left;
//	node right;
//}
//
public class LowestCommonAncestor {

	private node first, second = null;
	
	private void initialize(int first, int second) {
		this.first = new node(first);
		this.second = new node(second);
	}
	public node findLCA(node root) {
		
		// Base Condition
		if(root == null) {
			return null;
		}
		
		if(root.data == first.data || root.data == second.data) {
			return root;
		}
		node one = findLCA(root.left);
		node two = findLCA(root.right);
		if(one != null && two != null) {
			return root;
		}
		return one == null ?  two :  one;
	}
}
