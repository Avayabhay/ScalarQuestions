
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

    class nodeInfo{
        int min;
        int max;
        int size;
        boolean isBST;
        nodeInfo() {}
        
        nodeInfo(int size, int max, int min, boolean isBST)
        {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }  
    public class LargestBSTInBinaryTree {
        
        private int ans = Integer.MIN_VALUE;
        
        
        main(){
            return findLargest(root).size();
        }
        
        public nodeInfo findLargestBST(node root) {
            
            if(root == null) {
                return new nodeInfo(0,Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            }
            
            nodeInfo left = findLargestBST(root.left);
            nodeInfo right = findLargestBST(root.right);
            
            nodeInfo temp = new nodeInfo();
            temp.min = Math.min(left.min, root.data);
            temp.max = Math.max(right.max, root.data);
            
            temp.isBST = left.isBST && right.isBST && root.data > left.max && root.data < right.min;
            
            if(temp.isBST) {
                temp.size = left.size + right.size + 1;
            }
            else {
                temp.size = Math.max(left.size,  right.size);
            }
            
            return temp;
            
        }
        
    }