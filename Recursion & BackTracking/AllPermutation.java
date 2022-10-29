//Generate all the Permutations of the given Array

import java.util.ArrayList;
import java.util.Scanner;

public class AllPermutation {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter the Elements");
		//int target = sc.nextInt();
		int arr [] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean vis [] = new boolean[n];
		
		
		generateAllPermutations(arr, vis, new ArrayList<Integer>(), 0);
		
		sc.close();
	}

	private static void generateAllPermutations(int[] arr, boolean [] vis, ArrayList<Integer> store, int index) {
		// TODO Auto-generated method stub
		
		//Base Condition
		if(index == arr.length) {
			System.out.println(store);
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!vis[i]) {
				store.add(arr[i]);
				vis[i] = true;
				generateAllPermutations(arr, vis, store,  index + 1);
				vis[i] = false;
				store.remove(store.size() - 1);
			}
		}
		
	}
}

