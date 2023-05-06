

// class Node{
//     int data;
//     Node left;
//     Node right;
//     Node(int data){
//         this.data = data;
//         left=null;
//         right=null;
//     }
// }    

public class LowestCommonAncesorBST {
    public Node LCA(Node root, int n1, int n2)
	{
	   if(n2 < n1){
	       int temp = n1;
	       n1 = n2;
	       n2 = temp;
	   }
        // code here.  
        //base Condition
        if(root == null) return null;
        
        if(root.data == n1 || root.data == n2){
            return root;
        }
        
        if(n1 < root.data && n2 > root.data) {
            return root;
        }
        
        if(n1 < root.data && n2 < root.data){
            return LCA(root.left, n1, n2);
        }
        else{
            return LCA(root.right, n1, n2);
        }
        
    }
    
}

