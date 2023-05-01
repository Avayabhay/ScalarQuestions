package Binary Search Tree;


// node Class 
class node {
    int data;
    node left;
    node right;
    node nextRight;
  }
  
  public class ConnectNodesAtSameLevelUsingConstantExtraSpace {
      
      public void returnAns(node root) {
          
          //base condition
          if(root == null) return;
          
          //preserving root
          node currNode = root;
          node currNodeDown = root;
          //Mode down
          while(currNodeDown != null) {
              currNode = currNodeDown;
              
              //Move right to left
              while(currNode != null) {
                  //for One Node
                  if(currNode.left != null ) {
                      if(currNode.right != null) {
                          currNode.left.nextRight = currNode.right;
                      }
                      else {				
                          currNode.left.nextRight = getNextRight(currNode);
                      }
                  }
                  
                  if(currNode.right != null) {
                      currNode.right.nextRight = getNextRight(currNode);
                  }
                  currNode = currNode.nextRight;
              }
              
              currNodeDown = currNodeDown.left != null ? currNodeDown.left : (currNodeDown.right != null ? currNodeDown.right : getNextRight(currNodeDown));
          }
          
          
      }
      
      //funtion that return the next right child for the current Node
      public node getNextRight(node Node) {
          
          if(Node == null)
              return null;
          
          node currNode = Node.nextRight;
          
          while(currNode != null) {
              if(currNode.left != null) {
                  return currNode.left;
              }
              if(currNode.right != null) {
                  return currNode.right;
              }
              currNode = currNode.nextRight;
          }
          
          
          return null;
      }
      
  }
  
