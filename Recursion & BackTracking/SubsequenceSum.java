import java.util.ArrayList;
import java.util.Scanner;

public class SubsequenceSum {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter the target");
		int target = sc.nextInt();
		int arr [] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		countSubSeq(arrList, arr, new ArrayList<Integer>(), 0, target);
		
		for(ArrayList<Integer> list : arrList) {
			System.out.println(list);
		}
		
	}
	
	public static void countSubSeq(ArrayList<ArrayList<Integer>> ans, int [] arr,
			ArrayList<Integer> store, int index, int target) {
		//base Condition
		if(index >= arr.length) {
			if(target == 0) {
				ans.add(new ArrayList<>(store));
			}
			return;
		}
		
		countSubSeq(ans, arr, store,  index + 1, target);
		store.add(arr[index]);
		countSubSeq(ans, arr, store, index + 1, target - arr[index]);
		store.remove(store.size() -1);
		
	}

    
}

