//Given a set of positive integers, find all its subsets.
// Input : 
// array = {1, 2, 3}
// Output :
//               // this space denotes null element. 
// 1
// 1 2
// 1 2 3
// 1 3
// 2
// 2 3
// 3

class AllSubsets
{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        generateSubsets(A, 0, new ArrayList<Integer>(), ans);
        return ans;
        
    }
    
    public static void generateSubsets(ArrayList<Integer> arr, int index,
        ArrayList<Integer> store, ArrayList<ArrayList<Integer>> ans){
            //Base Condition
            if(index == arr.size()){
                ans.add(new ArrayList<Integer>(store));
                return;
            }
            
            //Select the next Element without choosing the 1st ele
            generateSubsets(arr, index + 1, store, ans);
            //Select the first element and recurse on the 2nd element
            store.add(arr.get(index));
            generateSubsets(arr, index + 1, store, ans);
            store.remove(store.size() -1);
            
        }
}