
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

// Problem : Given an Array which contains duplicate elements, Generate All Unique permutation
// eg : A [] = {1,1,2,2}
// O/P :  [], 1,2,1 1, 1 1 2, 1 1 2 2, 1 2, 1 2 2


//Solution: 
// The Idea is to create a frequency Map containing the element mapped to its freq.
// Then Generate all the permutation with element's freq


public class AllUniquePermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter the Elements");
		//int target = sc.nextInt();
		int arr [] = new int[n];
		
		LinkedHashMap<Integer, Integer> myMap = new LinkedHashMap<>();
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(myMap.containsKey(arr[i])) {
				myMap.put(arr[i], myMap.get(arr[i]) + 1);
			}
			else {
				myMap.put(arr[i], 1);
				list.push(arr[i]);
			}
		}
		ArrayList<ArrayList<pairTemp>> arrList = new ArrayList<>();
 		boolean vis [] = new boolean[myMap.size()];
		generateAllUniquePermutations(arrList, arr, new ArrayList<pairTemp>(), 0, myMap, vis, list);
		
		sc.close();
	}

	private static void generateAllUniquePermutations(ArrayList<ArrayList<pairTemp>> arrList, int[] arr,
			ArrayList<pairTemp> store, int index, HashMap<Integer, Integer> myMap, boolean [] vis, LinkedList<Integer> list ) {
		// TODO Auto-generated method stub
		if(index == myMap.size()) {
			//printValue(myMap, )
			//ystem.out.println("-------------------------");
			for(pairTemp a : store) {
				for(int i=0; i<a.b; i++) {
					System.out.print(a.a+", ");
				}
//				System.out.print(a.a+" : "+a.b);
			}
			System.out.println();
			return;
		}
		
		//
		int ele = list.get(index);
		
		for(int i=0; i<=myMap.get(ele); i++) {
			store.add(new pairTemp(ele, i));
			generateAllUniquePermutations(arrList, arr, store, index + 1, myMap, vis, list);
			store.remove(store.size() -1);
		}
	
	}
	

}
class pairTemp{
	int a;
	 int b;
	 pairTemp(int a, int b){
		 this.a = a;
		 this.b =b;
	 }
}
